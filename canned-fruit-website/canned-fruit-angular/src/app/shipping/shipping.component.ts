import { Component, OnInit, signal, WritableSignal } from '@angular/core';

import { Observable } from 'rxjs';
import { ShippingSvcService } from '../shipping-svc.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { Shipping } from '../shippings';
import { Sort, MatSortModule } from '@angular/material/sort';

@Component({
  selector: 'app-shipping',
  templateUrl: './shipping.component.html',
  styleUrls: ['./shipping.component.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterModule, MatSortModule],
  standalone: true
})
export class ShippingComponent implements OnInit {

  shippingCosts!: Shipping[];
  sortedData: WritableSignal<Shipping[]> = signal([]);
  isEven: any;
  lastSortDirection: WritableSignal<string> = signal('');

  constructor(private shippingSvc: ShippingSvcService) {
    this.sortedData.set(this.shippingCosts?.slice());
  }

  ngOnInit(): void {
    /* https://stackoverflow.com/questions/44940695/how-to-convert-observableany-to-array
    converting Observable to array that can be sliced */
    this.shippingSvc.getShippingPrices().subscribe(data => {
      this.shippingCosts = data;
      this.sortedData.set(this.shippingCosts.slice());
      console.log("ShippingComponent.ngOnInit(): shippingCosts=" + this.shippingCosts);
    });
  }

  sortData(sort: Sort) {
    const data = this.shippingCosts.slice();
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