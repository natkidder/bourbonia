import { AfterViewInit, ChangeDetectionStrategy, ChangeDetectorRef, Component, Inject, NgModule, OnInit, signal, ViewChild, WritableSignal } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormGroup, FormControl, FormsModule, ReactiveFormsModule, Validators, FormBuilder, FormArray } from '@angular/forms';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { CommonModule } from '@angular/common';

import { CannedFruitService } from '../canned-fruit.service';
import { CustomerService } from '../customer-svc.service';
import { CannedFruit } from '../cannedFruit';
import { AbbrevCannedFruit } from '../abbrevCannedFruit';
import { Customer } from '../customer';
import { CustomerOrderItem } from '../customerOrderItem';
import { Shipping } from '../shippings';
import { ShippingSvcService } from '../shipping-svc.service';
import { LOT_CNTS } from '../../assets/constants';
import { CustomerOrderService, CustomerOrder } from '../customerOrder-svc.service';
import { STATES } from '../../assets/constants';
import { Address } from '../address';


@Component({
  selector: 'app-shipping',
  templateUrl: './sandbox.component.html',
  styleUrls: ['./sandbox.component.css'],
  imports: [MatTableModule, MatSortModule, FormsModule, CommonModule, ReactiveFormsModule, RouterModule],
  standalone: true
})
export class SandboxComponent implements OnInit {
  //sortedData: WritableSignal<Customer[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  isUpdating: boolean = false;
  myForm: FormGroup; //<{ fruitSelection: FormControl<string | null> }>;
  myForm2: FormGroup;
  hasSelectedItems: boolean = false;
  customerOrder: CustomerOrder = {} as CustomerOrder;
  customerOrderItems: CustomerOrderItem[] = [];
  allCannedFruits: CannedFruit[] = [];
  sortedACF: WritableSignal<CannedFruit[]> = signal([]);
  selectedIds: number[] = [];
  customer: Customer | null = {} as Customer;
  orderedCannedFruits: CannedFruit[] = [];
  sortedOCF: WritableSignal<CannedFruit[]> = signal([]);
  sortedAddresses: WritableSignal<Address[]> = signal([]);
  customerPocEmail: string = '';
  isChecked: boolean | null = false; // Property to store the selected checkbox value
  showMyForm: boolean = false;
  readonly LOT_CNTS = LOT_CNTS; // For use in the template
  estTotalCost: WritableSignal<number> = signal(0);

  constructor(private formBuilder: FormBuilder, public cannedFruitSvc: CannedFruitService, public customerSvc: CustomerService, private cdr: ChangeDetectorRef, private shippingSvc: ShippingSvcService, private activatedRoute: ActivatedRoute, private customerOrderSvc: CustomerOrderService) {
    this.myForm = this.formBuilder.group({
      customerPocEmail: ['', [Validators.required, Validators.email]],
      selectedItems: this.formBuilder.array([]) // Initialize an empty FormArray
    });
    this.myForm2 = this.formBuilder.group({
      addrRadios: ['', Validators.required],
      shippingRadios: ['', Validators.required],
      cntItems: this.formBuilder.array([]), // Initialize an empty FormArray
      nameOnCard: ['', Validators.required],
      cardNbr: ['', [Validators.required, Validators.pattern('^[0-9]{16}$')]],
      expirationDt: ['', [Validators.required, Validators.pattern('^(0[1-9]|1[0-2])\\/([0-9]{2})$')]], // MM/YY format
      cvv: ['', [Validators.required, Validators.pattern('^[0-9]{3}$')]]
    });
  }
  formattedPhone: string = '';
  selectedCustomerId: number = 5;
  selectedCfIds: number[] = [1, 4, 8, 9, 109];
  selectedAddrOption: string | null = null; // Property to store the selected radio button value
  selectedShippingOption: string | null = null; // Property to store the selected radio button value
  shippings: Shipping[] = [];
  sortedShippings: WritableSignal<Shipping[]> = signal([]);
  async ngOnInit(): Promise<void> {
    let customerParam: string | null = null;
    this.activatedRoute.queryParams.subscribe(params => {
      customerParam = params['customer'];
    });
    console.log('ngOnInit - customerParam:', customerParam);
    if (customerParam) {
      const customers: Customer[] = JSON.parse(customerParam);
      this.customer = customers[0];
      this.sortedAddresses.set(this.customer.addresses.slice());
    } else {
      console.log('No customer data in query params');
    } await this.setupForm();
  }

  async setupForm(): Promise<void> {
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getCannedFruits().subscribe((data) => {
        this.allCannedFruits = data;
        resolve();
      });
    });
    this.sortedACF.set(this.allCannedFruits.slice());
    this.addCheckboxes();
    this.showMyForm = true;
    this.cdr.detectChanges();
    this.addCheckboxes();
    await new Promise<void>((resolve) => {
      this.shippingSvc.getShippingPrices().subscribe((data) => {
        this.shippings = data;
        resolve();
      });
    });
    this.sortedShippings.set(this.shippings.slice());
  }
  addCheckboxes() {
    this.allCannedFruits.forEach(() => this.selectedItems.push(new FormControl(false)))
  }

  async onSubmitMyForm() {
    console.log('onSubmit selectedIds: ', this.getSelectedItemsIds());
    console.log('this.customer: ', this.customer);
    if (this.customer) {
      this.formattedPhone = this.customerSvc.viewPhoneNumber(this.customer?.pocPhone);
    }
    this.customerOrder.customer = this.customer!;
    console.log('this.customerOrder: ', this.customerOrder);
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getCannedFruitsByIdList(this.selectedIds).subscribe((data) => {
        if (data) {
          this.orderedCannedFruits = data;
        } else {
          console.log('No canned fruits found for the selected IDs.');
          this.orderedCannedFruits = [];
        }
        resolve();
      });
    });
    this.sortedOCF.set(this.orderedCannedFruits.slice());
    this.addSelects();
    this.cdr.detectChanges();
    this.myForm2.get('addrRadios')?.valueChanges.subscribe(selectedValue => {
      this.selectedAddrOption = selectedValue;
      if (this.isShippingSelected()) {
        let shippingSelectedValue = JSON.parse(this.myForm2.get('shippingRadios')?.value);
        this.estTotalCost.set(this.customerOrderSvc.calcTotalCosts(this.myForm2.value, JSON.parse(selectedValue), shippingSelectedValue));
      }

    });
    this.myForm2.get('shippingRadios')?.valueChanges.subscribe(selectedValue => {
      this.selectedShippingOption = selectedValue;
      if (this.isAddrSelected()) {
        let addrSelectedValue = JSON.parse(this.myForm2.get('addrRadios')?.value);
        this.estTotalCost.set(this.customerOrderSvc.calcTotalCosts(this.myForm2.value, addrSelectedValue, JSON.parse(selectedValue)));
      }
    });
  }
  get cntItems() {
    return this.myForm2.get('cntItems') as FormArray;
  }
  get selectedItems() {
    return this.myForm.get('selectedItems') as FormArray;
  }

  addSelects() {
    this.orderedCannedFruits.forEach(cannedFruit => this.cntItems.push(new FormControl('{ "id": ' + cannedFruit.id + ', "cnt": ' + this.LOT_CNTS[0] + ', "volume": ' + cannedFruit.volume + ', "pricePer": ' + cannedFruit.pricePer + '}', Validators.required))); // set the default, the same as the option element's value
  }
  getSelectedItemsIds() {
    this.selectedIds = this.myForm.value.selectedItems
      .map((checked: boolean, i: number) => checked ? this.allCannedFruits[i].id : null)
      .filter((id: number | null) => id !== null) as number[];
    return this.selectedIds;
  }
  isAddrSelected(): boolean {
    const addrValue = this.myForm2.get('addrRadios')?.value;
    return (addrValue !== null && addrValue !== '');
  }
  isShippingSelected(): boolean {
    const shippingValue = this.myForm2.get('shippingRadios')?.value;
    return (shippingValue !== null && shippingValue !== '');
  }
  onChangeCnt(event: any, index: number) {
    const selectedValue = event.target.value;
    this.cntItems.at(index).setValue(selectedValue);
    if (this.isAddrSelected() && this.isShippingSelected()) {
      // Both address and shipping options are selected, recalculate total cost
      const addrOptionParsed = this.selectedAddrOption ? JSON.parse(this.selectedAddrOption) : null;
      const shippingOptionParsed = this.selectedShippingOption ? JSON.parse(this.selectedShippingOption) : null;
      this.estTotalCost.set(this.customerOrderSvc.calcTotalCosts(this.myForm2.value, addrOptionParsed, shippingOptionParsed));
    }
  }
  isSubmitDisabled(): boolean {
    return !(this.myForm2.valid && this.isAddrSelected() && this.isShippingSelected());
  }

  submitMyForm2(arg0: any, customer: Customer | null) {
    console.log('myForm2.value: ', arg0);
    if (customer) {
      console.log('customer: ', customer.id);
    } else {
      console.log('customer is null');
    }
    this.customerOrder = this.customerOrderSvc.createCustomerOrder(arg0, customer ? customer.id : 0);
    this.isUpdating = true;
    this.customerOrderSvc.addCustomerOrder(this.customerOrder).subscribe({
      next: (data) => {
        console.log('Order created successfully:', data);
        this.isUpdating = false;
        if ('id' in data) {
          alert('Order ID  ' + data.id + '  successfully created!');
        }
        // Optionally reset the form or navigate away
      },
      error: (error) => {
        console.error('Error creating order:', error);
        this.isUpdating = false;
        alert('Error creating order. Please try again.');
      }
    });
  }

  //TODO: Move these sorting functions to a shared utility service
  sortDataACF(sort: Sort) {
    const data = this.allCannedFruits.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedACF.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedACF.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'fruit':
          return compare(a.fruit, b.fruit, isAsc);
        case 'medium':
          return compare(a.medium.mediumName, b.medium.mediumName, isAsc);
        case 'unitType':
          return compare(a.unitType, b.unitType, isAsc);
        case 'volume':
          return compare(a.volume, b.volume, isAsc);
        case 'container':
          return compare(a.container, b.container, isAsc);
        case 'pricePer':
          return compare(a.pricePer, b.pricePer, isAsc);
        default:
          return 0;
      }
      this.lastSortDirection.set(sort.direction !== '' ? sort.direction : this.lastSortDirection());
    }));
  }
  sortDataOCF(sort: Sort) {
    const data = this.orderedCannedFruits.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedOCF.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedOCF.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'fruit':
          return compare(a.fruit, b.fruit, isAsc);
        case 'medium':
          return compare(a.medium.mediumName, b.medium.mediumName, isAsc);
        case 'unitType':
          return compare(a.unitType, b.unitType, isAsc);
        case 'volume':
          return compare(a.volume, b.volume, isAsc);
        case 'container':
          return compare(a.container, b.container, isAsc);
        case 'pricePer':
          return compare(a.pricePer, b.pricePer, isAsc);
        default:
          return 0;
      }
      this.lastSortDirection.set(sort.direction !== '' ? sort.direction : this.lastSortDirection());
    }));
  }
  sortDataAddr(sort: Sort) {
    const data = this.customer?.addresses.slice() || [];
    if (!sort.active || sort.direction === '') {
      this.sortedAddresses.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedAddresses.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        /* case 'id':
          return compare(a.id, b.id, isAsc); */
        case 'addrType':
          return compare(a.addrType, b.addrType, isAsc);
        case 'address':
          return compare(a.street1 + a.street2 + a.city + a.state + a.zip, b.street1 + b.street2 + b.city + b.state + b.zip, isAsc);
        default:
          return 0;
      }
      this.lastSortDirection.set(sort.direction !== '' ? sort.direction : this.lastSortDirection());
    }));
  }
  sortDataShippings(sort: Sort) {
    const data = this.shippings.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedShippings.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedShippings.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        /* case 'id':
          return compare(a.id, b.id, isAsc); */
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
/* const pocEmail = this.myForm.value.customerPocEmail;
await new Promise<void>((resolve) => {
    this.customerSvc.getCustomerByEmail(pocEmail).subscribe((data) => {
        if (data) {
            this.customer = data;
            this.cdr.detectChanges();
            this.formattedPhone = this.customerSvc.viewPhoneNumber(this.customer?.pocPhone || '');
        } else {
            console.log('No customer found for the provided email: ' + pocEmail);
            this.customer = null;
        }
        resolve();
    });
}); */
