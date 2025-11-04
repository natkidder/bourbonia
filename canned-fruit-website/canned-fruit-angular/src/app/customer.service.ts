import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }
  customers: Customer[] = [];
  getOneCustomer(id: number) {
    return this.http.get<Customer>('api2/customer/' + id);
  }
  getCustomers() {
    return this.http.get<Customer[]>('api2/customer');
  }
  addCustomer(customer: Customer) {
    return this.http.post('api2/customer', customer);
  }
  updCustomer(customer: Customer) {
    console.log("updCustomer: Customer id:"+customer.id);
    return this.http.put('api2/customer/' + customer.id, customer);
  }
  deleteCustomer(id: number) {
    return this.http.delete('api2/customer/' + id);
  }
  getSomeCustomers(businessName: string, outletName: string, pocFirst: string, pocLast: string) {
    return this.http.get<Customer[]>('api2/customer?businessName=' + businessName + '&outletName=' + outletName + '&pocFirst=' + pocFirst + '&pocLast=' + pocLast); 
  }
  formatPhoneNumber(phoneNumber: string): string {
    // Remove all non-digit characters
    const cleaned = phoneNumber.replace(/\D/g, '');

    // Format the cleaned number
    const match = cleaned.match(/^(\d{3})(\d{3})(\d{4})$/);
    if (match) {
      return `(${match[1]}) ${match[2]}-${match[3]}`;
    }
    return phoneNumber; // Return the original if it doesn't match the expected format
  }
}
