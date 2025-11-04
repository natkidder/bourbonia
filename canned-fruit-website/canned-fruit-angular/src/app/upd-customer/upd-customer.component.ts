import { AfterViewInit, Component, NgModule, OnInit, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef, WritableSignal, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerService } from '../customer-svc.service';
import { Customer } from '../customer';
import { Address } from '../address';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { STATES } from '../../assets/constants';
import { CommonModule } from '@angular/common';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-customer',
  templateUrl: './upd-customer.component.html',
  styleUrls: ['./upd-customer.component.css'],
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [MatTableModule, MatSortModule, FormsModule, ReactiveFormsModule, CommonModule, RouterLink]
})
export class UpdCustomerComponent implements OnInit {
  sortedData: WritableSignal<Customer[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  customers: Customer[] = [];
  selectedCustomer: Customer | null = null;
  isUpdating: boolean = false;
  myForm5: FormGroup;
  showMyForm4: WritableSignal<boolean> = signal(false);
  showMyForm5: WritableSignal<boolean> = signal(false);
  //@ViewChild(MatSortModule) sort!: MatSortModule;

  states = STATES; // For use in the template
  addresses!: FormArray;
  constructor(private formBuilder: FormBuilder, private router: Router, public customerSvc: CustomerService, private cdr: ChangeDetectorRef) {
    this.addresses = this.formBuilder.array([]);
    this.myForm5 = this.formBuilder.group({
      // Other controls in your main form group
      id: [''],
      businessName: ['', Validators.required],
      outletName: ['', Validators.required],
      pocFirst: ['', Validators.required],
      pocLast: ['', Validators.required],
      pocPhone: ['', [Validators.required, Validators.pattern('^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$')]],
      pocEmail: ['', [Validators.required, Validators.email]],
      // The FormArray containing FormGroups
      addresses: this.formBuilder.array([])
    });
  }

  selectedOption: string | null = null; // Property to store the selected radio button value
  businessNameEntered: string | null = null;
  outletNameEntered: string | null = null;
  pocFirstEntered: string | null = null;
  pocLastEntered: string | null = null;

  myForm2 = new FormGroup({
    customerSelection: new FormControl('')
  });


  ngOnInit(): void {
    this.addressArray.clear();
    this.addresses.clear();
  }
  async setCustomerFilter(formValue: any) {
    //console.log('formValue: ', formValue); ////////
    let businessName: string = formValue.businessName === null ? '' : formValue.businessName;
    let outletName: string = formValue.outletName === null ? '' : formValue.outletName;
    let pocFirst: string = formValue.pocFirst === null ? '' : formValue.pocFirst;
    let pocLast: string = formValue.pocLast === null ? '' : formValue.pocLast;
    await new Promise<void>((resolve) => {
      this.customerSvc.getSomeCustomers(businessName, outletName, pocFirst, pocLast).subscribe(data => {
        this.customers = data;
        resolve();
      });
    });
    console.log('this.customers: ', this.customers); ////////
    this.sortedData.set(this.customers);
    /* this.customers.subscribe((customers: Customer[]) => {
      customers.forEach((customer: Customer) => {
        console.log('customer: ', JSON.stringify(customer));
      }
      )
    }); */
    this.myForm2.setErrors({ invalid: true }); // disable update button until a customer is selected
    this.router.navigate([this.router.url]); // refresh the page
    if (businessName || outletName || pocFirst || pocLast) {
      this.showMyForm4.set(true);
      //this.cdr.detectChanges();
    } else {
      this.showMyForm4.set(false);
      //this.cdr.detectChanges();
    }
  }

  isOptionSelected(): boolean {
    return this.selectedOption !== null;
  }
  isFilterEntered(): boolean {
    // TODO: check for non-blank strings and not just null
    return this.businessNameEntered !== null || this.outletNameEntered !== null || this.pocFirstEntered !== null || this.pocLastEntered !== null;
  }

  async setUpdCustomer(formInput: any) {
    console.log('customerID: ', formInput.updRadios); ////////
    if (formInput.updRadios) {
      const custID: number = +formInput.updRadios;
      this.selectedCustomer = (await this.customerSvc.getOneCustomer(custID).toPromise()) ?? null;
      console.log('this.selectedCustomer: ', this.selectedCustomer); /////////
      this.myForm5.reset();
      this.addressArray.clear();
      //this.myForm5.addresses.clear();
      if (this.selectedCustomer) {
        this.myForm5.patchValue({
          id: this.selectedCustomer.id,
          businessName: this.selectedCustomer.businessName,
          outletName: this.selectedCustomer.outletName,
          pocFirst: this.selectedCustomer.pocFirst,
          pocLast: this.selectedCustomer.pocLast,
          pocPhone: this.customerSvc.viewPhoneNumber(this.selectedCustomer.pocPhone),
          pocEmail: this.selectedCustomer.pocEmail
        });
        if (this.selectedCustomer.addresses) {
          this.addresses = this.formBuilder.array([]);
          for (let addr of this.selectedCustomer.addresses) {
            console.log('Address to patch:', addr);
            const addrGroup = this.createAddressFormGroup();
            addrGroup.patchValue({
              id: addr.id,
              addrType: addr.addrType,
              street1: addr.street1,
              street2: addr.street2,
              city: addr.city,
              state: addr.state,
              zip: addr.zip
            });
            this.addresses.push(addrGroup);
          }
          this.myForm5.setControl('addresses', this.addresses);
        }
      }
    }
    if (this.selectedCustomer) {
      this.sortedData.set([this.selectedCustomer]);
      this.showMyForm5.set(true);
      //this.cdr.detectChanges();
    } else {
      this.showMyForm5.set(false);
      //this.cdr.detectChanges();
    }

  }

  createAddressFormGroup(): FormGroup {
    return this.formBuilder.group({
      id: [''],
      addrType: ['', Validators.required],
      street1: ['', Validators.required],
      street2: [''],
      city: ['', Validators.required],
      state: [this.states, Validators.required],
      zip: ['', [Validators.required, Validators.pattern('^[0-9]{5}(?:-[0-9]{4})?$')]]
    });
  }


  get addressArray(): FormArray {
    return this.myForm5.get('addresses') as FormArray;
  }

  addAddress(): void {
    console.log('Adding address');
    this.isUpdating = true;
    this.addressArray.push(this.createAddressFormGroup());
  }

  removeAddress(index: number): void {
    console.log('Removing address at index:', index);
    this.addressArray.removeAt(index);
  }

  /*   populateAddresses(data: any[]): void {
      data.forEach(address => {
        this.addresses.push(this.formBuilder.group({
          addrType: [address.addrType, Validators.required],
          street1: [address.street1, [Validators.required]]
        }));
      });
    } */


  onForm5Submit() {
    //console.log('isUpdating:', this.isUpdating); ////////
    if (!this.isUpdating) {
      console.log('Form Submitted');
      console.log(this.myForm5.value);
      this.selectedCustomer = this.responseToCustomer(this.myForm5.value);
      this.selectedCustomer.pocPhone = this.customerSvc.formatPhoneNumber(this.selectedCustomer.pocPhone); // remove punctuation so it's just digits
      console.log('Customer to update:', this.selectedCustomer); ////////
      this.customerSvc.updCustomer(this.selectedCustomer).subscribe(
        (response) => {
          if (response.hasOwnProperty('id')) {
            const id = (response as any).id;
            alert('Customer Nbr  ' + id + ',  ' + (response as any).pocEmail + '  successfully updated');
            console.log('customer added successfully:', response);
            let origCustomer = this.customers.filter(customer => customer.id === id);
            if (origCustomer && this.selectedCustomer) {
              Object.assign(origCustomer[0], this.selectedCustomer);
              this.sortedData.set(this.customers);
            }
            this.myForm5.reset();
            this.addressArray.clear();
          } else {
            console.error('Unexpected response format:', response);
          }
        },
        (error) => {
          console.error('Error updating customer:', error);
        }
      );
    }
    this.isUpdating = false;
  }
  responseToCustomer(response: any): Customer {
    let customer: Customer = {} as Customer;
    customer.id = response.id;
    customer.businessName = response.businessName;
    customer.outletName = response.outletName;
    customer.pocFirst = response.pocFirst;
    customer.pocLast = response.pocLast;
    customer.pocPhone = response.pocPhone;
    customer.pocEmail = response.pocEmail;
    customer.addresses = response.addresses;
    return customer;
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