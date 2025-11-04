import { Component, NgModule } from '@angular/core';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { CustomerService } from '../customer-svc.service';
import { STATES } from '../../assets/constants';
import { Customer } from '../customer';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-profile-editor',
  templateUrl: './add-selfCustomer.component.html',
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterModule],
  standalone: true
})

export class AddSelfCustomerComponent {
  myForm: FormGroup;
  isAdding: boolean = true;
  customer!: Customer;

  states = STATES; // For use in the template
  constructor(private formBuilder: FormBuilder, private customerSvc: CustomerService) {
    this.myForm = this.formBuilder.group({
      // Other controls in your main form group
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
  ngOnInit(): void {
    // Initialize with one address FormGroup
    this.addressArray.push(this.createAddressFormGroup());
    console.log('AddSelfCustomerComponent initialized'); ////////
  }

  createAddressFormGroup(): FormGroup {
    return this.formBuilder.group({
      addrType: ['', Validators.required],
      street1: ['', Validators.required],
      street2: [''],
      city: ['', Validators.required],
      state: [this.states, Validators.required],
      zip: ['', [Validators.required, Validators.pattern('^[0-9]{5}(?:-[0-9]{4})?$')]]
    });
  }

  // Getter to easily access the FormArray
  get addressArray(): FormArray {
    return this.myForm.get('addresses') as FormArray;
  }

  addAddress(): void {
    console.log('Adding address');
    this.isAdding = true;
    this.addressArray.push(this.createAddressFormGroup());
  }

  removeAddress(index: number): void {
    console.log('Removing address at index:', index);
    this.addressArray.removeAt(index);
  }

  onSubmit() {
    console.log('isAdding:', this.isAdding); ////////
    if (!this.isAdding) {
      console.log('Form Submitted');
      console.log(this.myForm.value);
      this.customer = this.responseToCustomer(this.myForm.value);
      this.customer.pocPhone = this.customerSvc.formatPhoneNumber(this.customer.pocPhone); // remove punctuation so it's just digits
      console.log('Customer to add:', this.customer); ////////
      this.customerSvc.addCustomer(this.customer).subscribe(
        (response) => {
          if (response.hasOwnProperty('id')) {
            alert('Customer Nbr ' + (response as any).id + ', ' + (response as any).pocEmail + " added"); ///////
            console.log('customer added successfully:', response);
            // Optionally, refresh the shipping costs after deletion
            this.myForm.reset();
            this.addressArray.clear();
          } else {
            console.error('Unexpected response format:', response);
          }
        },
        (error) => {
          console.error('Error adding customer:', error);
        }
      );
    }
    this.isAdding = false;
  }
  responseToCustomer(response: any): Customer {
    let customer: Customer = {} as Customer;
    customer.id = -1;
    customer.businessName = response.businessName;
    customer.outletName = response.outletName;
    customer.pocFirst = response.pocFirst;
    customer.pocLast = response.pocLast;
    customer.pocPhone = response.pocPhone;
    customer.pocEmail = response.pocEmail;
    for (let addr of response.addresses) {
      addr.id = -1;
    }
    customer.addresses = response.addresses;
    return customer;
  }
}