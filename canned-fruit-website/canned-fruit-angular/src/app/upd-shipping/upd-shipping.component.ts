import { AfterViewInit, Component, NgModule, OnInit, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef, WritableSignal, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray, FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ShippingSvcService } from '../shipping-svc.service';
import { Router, RouterModule } from '@angular/router';
import { Shipping } from '../shippings';
import { F } from '@angular/cdk/keycodes';
import { CommonModule } from '@angular/common';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';

@Component({
  // selector finds an element in the corresponding HTML entity (element, attribute, etc.)
  selector: 'app-upd-shipping',
  templateUrl: './upd-shipping.component.html',
  styleUrls: ['./upd-shipping.component.css'],
  standalone: true,
  imports: [MatTableModule, MatSortModule, CommonModule, FormsModule, ReactiveFormsModule, RouterModule],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UpdShippingComponent implements OnInit {
  isUpdating: boolean = false;
  myForm4: FormGroup;
  myForm5: FormGroup;
  selectedIds: number[] = [];
  shippings: Shipping[] = [];
  shippingsShown: WritableSignal<Shipping[]> = signal([]);
  selectedShipping: Shipping | null = null;
  sortedData: WritableSignal<Shipping[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  joinedIds: number[] = [];
  distinctFruits: string[] = [];
  selectedOption: string | null = null; // Property to store the selected radio button value
  readonly ALL_FRUITS_OPTION: string = '--All--';
  i: any;
  //readonly ALL_FRUITS_ARG: string = '';
  constructor(private formBuilder: FormBuilder, public shippingSvc: ShippingSvcService, private cdr: ChangeDetectorRef) {
    this.myForm4 = this.formBuilder.group({
      selectedItems: this.formBuilder.array([]) // Initialize an empty FormArray
    });
    this.myForm5 = this.formBuilder.group({
      // Other controls in your main form group
      id: [''],
      type: ['', Validators.required],
      price: ['', [Validators.required, Validators.min(0)]],
    });
  }
  async ngOnInit(): Promise<void> {
    await new Promise<void>((resolve) => {
      this.shippingSvc.getShippingPrices().subscribe((data) => {
        this.shippings = data;
        this.shippingsShown.update(() => this.shippings);
        this.sortedData.set(this.shippings.slice());
        resolve();
      });
    });
    console.log('shippings 02:', this.shippings);
  }

  async setupForm(): Promise<void> {
  }

  isOptionSelected(): boolean {
    return this.selectedOption !== null;
  }

  async setUpdShipping(formInput: any) {
    if (formInput.updRadios) {
      const shippingID: number = +formInput.updRadios;
      this.selectedShipping = (await this.shippingSvc.getOneShippingPrice(shippingID).toPromise()) ?? null;
      console.log('this.selectedShipping: ', this.selectedShipping);
      this.myForm5.reset();
      if (this.selectedShipping) {
        this.myForm5.patchValue({
          id: this.selectedShipping.id,
          type: this.selectedShipping.type,
          price: this.selectedShipping.price
        });
      }
    }
  }
  onForm5Submit() {
    if (!this.isUpdating) {
      console.log('Form Submitted');
      console.log(this.myForm5.value);
      this.selectedShipping = this.responseToShipping(this.myForm5.value);
      this.shippingSvc.updShippingPrice(this.selectedShipping).subscribe(
        (response) => {
          if (response.hasOwnProperty('id')) {
            alert('Shipping Nbr  ' + (response as any).id + ' successfully updated');
            console.log('shipping added successfully:', response);
            const id = (response as any).id;
            let origShipping = this.shippings.filter(shipping => shipping.id === id);
            if (origShipping && this.selectedShipping) {
              Object.assign(origShipping[0], this.selectedShipping);
            }
            //this.selectedOption = null; // Clear the selected radio button 
            this.myForm5.reset();
          } else {
            console.error('Unexpected response format:', response);
          }
        },
        (error) => {
          console.error('Error updating shipping:', error);
        }
      );
    }
    this.isUpdating = false;
  }
  responseToShipping(response: any): Shipping {
    let shipping: Shipping = {} as Shipping;
    console.log('responseToShipping response:', response); ////////
    shipping.id = response.id;
    shipping.type = response.type;
    shipping.price = response.price;
    return shipping;
  }
  //@ViewChild(MatSort) sort: MatSort | null = null;
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
