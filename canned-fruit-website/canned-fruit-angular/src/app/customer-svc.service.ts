import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { Address } from './address';
import { AbbrevCustomer } from './abbrev-customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }
  customers: Customer[] = [];
  getOneCustomer(id: number) {
    return this.http.get<Customer>('http://localhost:8081/api2/customer/' + id);
  }
  getCustomerByEmail(pocEmail: string) {
    return this.http.get<Customer>('http://localhost:8081/api2/customer/pocEmail/' + pocEmail, { withCredentials: true });
  }
  getCustomersByIdList(ids: number[]): Observable<Customer[]> {
    let namedParams = this.arrayToNamedParams(ids);
    return this.http.get<Customer[]>('http://localhost:8081/api2/customerIdCollection' + namedParams, { withCredentials: true });
  }
  addCustomer(customer: Customer) {
    console.log("addCustomer: Customer id:" + customer.id); //////
    return this.http.post('http://localhost:8081/api2/customer', customer);
  }
  updCustomer(customer: Customer) {
    console.log("updCustomer: Customer id:" + customer.id);
    return this.http.put('http://localhost:8081/api2/customer/' + customer.id, customer);
  }
  deleteCustomer(id: number) {
    return this.http.delete('http://localhost:8081/api2/customer/' + id);
  }
  getSomeCustomers(businessName: string, outletName: string, pocFirst: string, pocLast: string) {
    return this.http.get<Customer[]>('http://localhost:8081/api2/customer?businessName=' + businessName + '&outletName=' + outletName + '&pocFirst=' + pocFirst + '&pocLast=' + pocLast);
  }
  getSomeCustomerNoOrders(businessName: string, outletName: string, pocFirst: string, pocLast: string) {
    return this.http.get<AbbrevCustomer[]>('http://localhost:8081/api2/customerNoOrders?businessName=' + businessName + '&outletName=' + outletName + '&pocFirst=' + pocFirst + '&pocLast=' + pocLast);
  }
  public formatPhoneNumber(phoneNumber: string): string {
    console.log('Original phone number:', phoneNumber); //////
    // Remove all non-digit characters
    const cleaned = phoneNumber.replace(/\D/g, '');
    return cleaned;
  }
  public viewPhoneNumber(phoneNumber: string): string {
    //console.log('Original phone number:', phoneNumber); //////
    // Remove all non-digit characters
    const cleaned = phoneNumber.replace(/\D/g, '');

    // Format the cleaned number
    const match = cleaned.match(/^(\d{3})(\d{3})(\d{4})$/);
    if (match) {
      return `${match[1]}-${match[2]}-${match[3]}`;
    }
    return phoneNumber; // Return the original if it doesn't match the expected format
  }
  showPhoneNumber(phoneNumber: string): void {
    console.log('Original phone number:', phoneNumber); //////
  }

  public arrayToNamedParams(ids: number[]): string {
    return '?id=' + [...ids].join('&id=');
  }

}