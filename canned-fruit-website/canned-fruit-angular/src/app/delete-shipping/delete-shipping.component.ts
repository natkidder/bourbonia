import { Component, Inject, signal, WritableSignal } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, ReactiveFormsModule } from '@angular/forms';
import { ShippingSvcService } from '../shipping-svc.service';
import { Shipping } from '../shippings';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';

@Component({
  // selector finds an element in the corresponding HTML entirty (element, attribute, etc.)
  selector: 'app-check-box-example',
  templateUrl: './delete-shipping.component.html',
  styleUrls: ['./delete-shipping.component.css'],
  standalone: true,
  imports: [MatTableModule, MatSortModule, CommonModule, ReactiveFormsModule, RouterModule]
})
export class DeleteShippingComponent {
  isUpdating: boolean = false;
  myForm: FormGroup;
  selectedIds: number[] = [];
  shippings: Shipping[] = [];
  shippingIds: { id: number }[] = [];
  sortedData: WritableSignal<Shipping[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  isChecked: boolean | null = false; // Property to store the selected checkbox value
  constructor(private formBuilder: FormBuilder, @Inject(ShippingSvcService) public shippingSvc: ShippingSvcService) {
    this.myForm = this.formBuilder.group({
      selectedItems: this.formBuilder.array([]) // Initialize an empty FormArray
    });
    this.addCheckboxes();
  }
  async ngOnInit(): Promise<void> {
    let ids2: number[] = [];
    // synchronous wait for shippingIds to load
    await new Promise<void>((resolve) => {
      this.shippingSvc.getShippingNoOrders().subscribe((data) => {
        console.log('setupForm simple cust data: ', data); //////
        this.shippingIds = data;
        data.map((shippingId) => {
          ids2.push(shippingId.id);
          console.log('ids2 in loop: ', ids2, ' length', ids2.length); //////
        });
        resolve();
      });
    });
    // because the above is synchronous, all the looped appending and pushing works
    console.log('ngInit ids2: ', ids2, 'ids2.length: ', JSON.parse(JSON.stringify(ids2)).length); ////////
    // also synchronous wait, for full shippings to load
    await new Promise<void>((resolve) => {
      this.shippingSvc.getShippingsByIdList(ids2).subscribe((data) => {
        console.log('setupForm full shippings: ', data); //////
        this.shippings = data;
        resolve();
      });
    });
    this.shippings.sort((a, b) => b.price - a.price); // Sort by price descending
    // Clear existing checkboxes
    (this.myForm.get('selectedItems') as FormArray).clear();
    // Add new checkboxes based on the updated shippings list
    this.addCheckboxes();
    console.log('setupForm shippings: ', this.shippings); ////////
    this.sortedData.set(this.shippings);
    console.log('sortedData init: ', this.sortedData()); ////////
  }

  async setupForm(formValue: any): Promise<void> {

  }
  addCheckboxes() {
    this.shippings.forEach(() => this.selectedItems.push(new FormControl(false)));
    //console.log('addCheckBoxes shippings: ', this.shippings); ////////
  }

  get selectedItems() {
    return this.myForm.get('selectedItems') as FormArray;
  }

  getSelectedItemsIds() {
    //console.log('getSelectedItemsIds formValue: ', this.myForm.value); ////////
    this.selectedIds = this.myForm.value.selectedItems
      .map((checked: boolean, i: number) => checked ? this.shippings[i].id : null)
      .filter((id: number | null) => id !== null);
    return this.selectedIds;
  }

  onSubmit() {
    if (!confirm('Are you sure you want to delete the selected shipping terms?')) {
      return
    }
    console.log(this.getSelectedItemsIds());
    console.log('onSubmit shippings: ', this.shippings); ////////
    this.getSelectedItemsIds().map((id) =>
      this.shippingSvc.deleteShippingPrice(id).subscribe(
        (response) => {
          console.log('Shipping deleted successfully:', response);
          const index = this.shippings.findIndex(shipping => shipping.id === id);
          // console.log('index to remove: ', index);
          this.shippings = this.shippings.filter(shipping => shipping.id !== id);
          this.sortedData.set(this.shippings);
          // Also need to update the form array to remove the corresponding checkbox
          if (index !== -1) {
            (this.myForm.get('selectedItems') as FormArray).removeAt(index);
          }
        },
        (error) => {
          console.error('Error removing customer ' + id + ': ', error);
        }
      )
    );
  }
  sortData(sort: Sort) {
    const data = this.shippings.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedData.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'id':
          return compare(a.id, b.id, isAsc);
        case 'type':
          return compare(a.type, b.type, isAsc);
        case 'price':
          return compare(a.price, b.price, isAsc);
        default:
          return 0;
      }
      this.lastSortDirection.set(sort.direction !== '' ? sort.direction : this.lastSortDirection());
    }));
  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
