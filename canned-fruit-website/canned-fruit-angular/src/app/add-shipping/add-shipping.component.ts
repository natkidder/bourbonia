import { AfterViewInit, ChangeDetectionStrategy, ChangeDetectorRef, Component, NgModule, OnInit, signal, ViewChild, WritableSignal } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // Import FormsModule
import { Observable } from 'rxjs';
import { ShippingSvcService } from '../shipping-svc.service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { Shipping } from '../shippings';


@Component({
  // selector finds an element in the corresponding HTML entirty (element, attribute, etc.)
  selector: 'app-add-shipping',
  templateUrl: './add-shipping.component.html',
  styleUrls: ['./add-shipping.component.css'],
  standalone: true,
  imports: [MatTableModule, MatSortModule, FormsModule, CommonModule, ReactiveFormsModule, RouterModule] // Add FormsModule here
})
export class AddShippingComponent implements OnInit {

  shippingCosts!: Shipping[];
  sortedData: WritableSignal<Shipping[]> = signal([]);
  //newShipping!: Observable<{type: string, price: number }>;

  constructor(private router: Router,
    private shippingSvc: ShippingSvcService) { }

  async ngOnInit(): Promise<void> {
    await new Promise<void>(resolve =>
      this.shippingSvc.getShippingPrices().subscribe(data => {
        this.shippingCosts = data;
        this.sortedData.set([...this.sortedData(), ...this.shippingCosts.slice()]);
        resolve();
      })
    );
  }

  // This method is called when the form is submitted
  onSubmit(formValue: any) {
    console.log(formValue.type + ' ' + formValue.price);
    //this.newShipping = formValue;
    this.addShipping(formValue);
    this.router.navigate([this.router.url]);
  }

  async addShipping(newShipping: { type: string, price: number }) {
    this.shippingSvc.addShippingPrice(newShipping).subscribe(
      (response) => {
        console.log('Shipping price added successfully:', response);
        // Optionally, refresh the shipping costs after deletion
        this.shippingSvc.getShippingPrices().subscribe(data => {
          if (data) {
            this.shippingCosts = data;
            //this.sortedData.update(shippingCosts => [...this.sortedData(), new Shipping(0, newShipping.type, newShipping.price)]);
            this.sortedData.set(this.shippingCosts.slice());
          } else {
            console.error('No data received after adding shipping term.');
            this.shippingCosts = [];
          }
        });
      },
      (error) => {
        console.error('Error adding shipping term:', error);
      }
    );
  }

  sortData(sort: Sort) {
    const data = this.shippingCosts.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData.set(data);
      return;
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
    }));
  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

