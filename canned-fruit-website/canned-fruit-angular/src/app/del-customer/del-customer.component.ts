import { Component, ChangeDetectionStrategy, ChangeDetectorRef, WritableSignal, signal } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CustomerService } from '../customer-svc.service';
import { Customer } from '../customer';
import { AbbrevCustomer } from '../abbrev-customer';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-check-box-example',
  templateUrl: './del-customer.component.html',
  styleUrls: ['./del-customer.component.css'],
  standalone: true, // If using standalone component
  imports: [MatTableModule, MatSortModule, CommonModule, ReactiveFormsModule, RouterLink],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class DelCustomerComponent {
  sortedData: WritableSignal<Customer[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  isUpdating: boolean = false;
  myForm4: FormGroup;
  myForm1: FormGroup;
  selectedIds: number[] = [];
  customers: Customer[] = [];
  abbrevCustomers: AbbrevCustomer[] = [];
  isChecked: boolean | null = false; // Property to store the selected checkbox value
  joinedIds: number[] = [];
  namedParams: string = '?id=';
  showMyForm4: WritableSignal<boolean> = signal(false);
  constructor(private formBuilder: FormBuilder, public customerSvc: CustomerService, private cdr: ChangeDetectorRef) {
    this.myForm1 = new FormGroup({
      businessName: new FormControl(''),
      outletName: new FormControl(''),
      pocFirst: new FormControl(''),
      pocLast: new FormControl('')
    });
    this.myForm4 = this.formBuilder.group({
      selectedItems: this.formBuilder.array([]) // Initialize an empty FormArray
    });
    this.addCheckboxes();
  }
  myForm2 = new FormGroup({
    customerSelection: new FormControl('')
  });
  async ngOnInit(): Promise<void> {
  }

  async setupForm(formValue: any): Promise<void> {
    let businessName: string = formValue.businessName === null ? '' : formValue.businessName;
    let outletName: string = formValue.outletName === null ? '' : formValue.outletName;
    let pocFirst: string = formValue.pocFirst === null ? '' : formValue.pocFirst;
    let pocLast: string = formValue.pocLast === null ? '' : formValue.pocLast;
    this.namedParams = '?id=';
    let ids2: number[] = [];
    // synchronous wait for abbrevCustomers to load
    await new Promise<void>((resolve) => {
      this.customerSvc.getSomeCustomerNoOrders(businessName, outletName, pocFirst, pocLast).subscribe((data) => {
        console.log('setupForm simple cust data: ', data); //////
        this.abbrevCustomers = data;
        data.map((abbrevCustomer) => {
          ids2.push(abbrevCustomer.id);
          this.namedParams += abbrevCustomer.id + '&id=';
          console.log('ids2 in loop: ', ids2, ' length', ids2.length); //////
        });
        resolve();
      });
    });
    // because the above is synchronous, all the looped appending and pushing works
    console.log('setupForm namedParams: ', this.namedParams, ' ids2: ', ids2, 'ids2.length: ', JSON.parse(JSON.stringify(ids2)).length); ////////
    // also synchronous wait, for full customers to load
    await new Promise<void>((resolve) => {
      this.customerSvc.getCustomersByIdList(ids2).subscribe((data) => {
        console.log('setupForm full customers: ', data); //////
        this.customers = data;
        resolve();
      });
    });
    this.sortedData.set(this.customers.slice());
    // Clear existing checkboxes
    console.log('setupForm before clear customers: ', this.customers); ////////
    (this.myForm4.get('selectedItems') as FormArray).clear();
    // Add new checkboxes based on the updated customers list
    this.addCheckboxes();
    console.log('setupForm customers: ', this.customers); ////////
    if (businessName || outletName || pocFirst || pocLast) {
      this.showMyForm4.set(true);
      //this.cdr.detectChanges();
    } else {
      this.showMyForm4.set(false);
      //this.cdr.detectChanges();
    }
  }
  addCheckboxes() {
    this.customers.forEach(() => this.selectedItems.push(new FormControl(false)));
    //console.log('addCheckBoxes customers: ', this.customers); ////////
  }

  get selectedItems() {
    return this.myForm4.get('selectedItems') as FormArray;
  }

  getSelectedItemsIds() {
    //console.log('getSelectedItemsIds formValue: ', this.myForm4.value); ////////
    this.selectedIds = this.myForm4.value.selectedItems
      .map((checked: boolean, i: number) => checked ? this.customers[i].id : null)
      .filter((id: number | null) => id !== null);
    return this.selectedIds;
  }

  async onSubmit() {
    if (!confirm('Are you sure you want to delete the selected customers?')) {
      return
    }
    console.log(this.getSelectedItemsIds()); /////////
    await new Promise<void>((resolve) => {
      this.getSelectedItemsIds().map((id) =>
        this.customerSvc.deleteCustomer(id).subscribe(
          (response) => {
            console.log('Customer deleted successfully:', response);
            this.customers = this.customers.filter(customer => customer.id !== id);
            // Also need to update the form array to remove the corresponding checkbox
            const index = this.customers.findIndex(customer => customer.id === id);
            if (index !== -1) {
              (this.myForm4.get('selectedItems') as FormArray).removeAt(index);
            }
          },
          (error) => {
            console.error('Error removing customer ' + id + ': ', error);
          }
        )
      )
      resolve();
    });
    this.sortedData.set(this.customers.slice());
    this.setupForm(this.myForm1.value);
  }
  sortData(sort: Sort) {
    const data = this.customers.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedData.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'businessName':
          return compare(a.businessName, b.businessName, isAsc);
        case 'outletName':
          console.log('Comparing outlet names:'); ////////
          return compare(a.outletName, b.outletName, isAsc);
        case 'pocFirst':
          return compare(a.pocFirst, b.pocFirst, isAsc);
        case 'pocLast':
          return compare(a.pocLast, b.pocLast, isAsc);
        case 'pocPhone':
          return compare(a.pocPhone, b.pocPhone, isAsc);
        case 'pocEmail':
          return compare(a.pocEmail, b.pocEmail, isAsc);
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