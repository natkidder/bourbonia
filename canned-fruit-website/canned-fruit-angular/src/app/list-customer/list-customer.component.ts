import { AfterViewInit, Component, NgModule, OnInit, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef, WritableSignal, signal } from '@angular/core';

import { Observable } from 'rxjs';
import { CustomerService } from '../customer-svc.service';
import { Customer } from '../customer';
import { FormGroup, FormControl, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Medium } from '../medium';
import { Router, RouterLink } from '@angular/router';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css'],
  standalone: true,
  imports: [MatTableModule, MatSortModule, FormsModule, CommonModule, ReactiveFormsModule, RouterLink],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  selectedFruit: string = '';
  sortedData: WritableSignal<Customer[]> = signal([]);
  showTable: boolean = false;
  lastSortDirection: WritableSignal<string> = signal('');
  //@ViewChild(MatSortModule) sort!: MatSortModule;

  constructor(private router: Router, public customerSvc: CustomerService, private cdr: ChangeDetectorRef) { }
  selectedOption: string = '';
  myForm2 = new FormGroup({
    customerSelection: new FormControl(''),
  });

  ngOnInit(): void {
  }
  async setCustomerFilter(formValue: any) {
    let businessName: string = formValue.businessName;
    let outletName: string = formValue.outletName;
    let pocFirst: string = formValue.pocFirst;
    let pocLast: string = formValue.pocLast;
    await new Promise<void>((resolve) => {
      this.customerSvc.getSomeCustomers(businessName, outletName, pocFirst, pocLast).subscribe(data => {
        this.customers = data.slice();
        resolve();
      });
    });
    if (businessName || outletName || pocFirst || pocLast) {
      this.showTable = true;
      this.cdr.detectChanges();
    } else {
      this.showTable = false;
      this.cdr.detectChanges();
    }
    this.sortedData.set(this.customers.slice());
    this.router.navigate([this.router.url]); // refresh the page
    //TODO: format phone numbers in the table
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