import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Address } from './address';
import { AbbrevCustomer } from './abbrev-customer';
import { Observable } from 'rxjs';
import { STATE_TAX_RATES } from '../assets/constants';

export class Customer {
  id!: number;
}
export class Shipping {
  id!: number;
}
export class CannedFruit {
  id!: number;
}
export class ShipToAddress {
  id!: number;
}
export class CustomerOrderItem {
  cannedFruit!: CannedFruit;
  cnt!: number;
}
export class CustomerOrder {
  id!: number;
  customer!: Customer;
  nameOnCard!: string
  cardNbr!: string;
  expirationDt!: string;
  cvv!: string;
  orderStatus!: string;
  customerOrderItems!: CustomerOrderItem[];
  shipping!: Shipping;
  shipToAddress!: ShipToAddress;
}

@Injectable({
  providedIn: 'root'
})
export class CustomerOrderService {

  constructor(private http: HttpClient) { }
  customers: Customer[] = [];
  getOneCustomerOrder(id: number) {
    return this.http.get<CustomerOrder>('http://localhost:8081/api2/customerOrder/' + id);
  }
  getAllCustomerOrders() {
    return this.http.get<CustomerOrder[]>('http://localhost:8081/api2/customerOrder');
  }
  getCustomerOrderByEmail(pocEmail: string) {
    return this.http.get<Customer>('http://localhost:8081/api2/customerOrder?pocEmail=' + pocEmail, { withCredentials: true });
  }
  addCustomerOrder(customerOrder: CustomerOrder) {
    return this.http.post('http://localhost:8081/api2/customerOrder', customerOrder);
  }
  cancelCustomerOrder(id: number) {
    return this.http.put('http://localhost:8081/api2/customerOrderCancel/' + id, {});
  }
  deleteCustomerOrder(id: number) {
    return this.http.delete('http://localhost:8081/api2/customerOrder/' + id);
  }

  createCustomerOrder(submittedForm: any, customerId: number): CustomerOrder {
    const customerOrderItems: CustomerOrderItem[] = submittedForm.cntItems.map((item: any) => {
      const parsedItem = JSON.parse(item);
      const customerOrderItem = new CustomerOrderItem();
      customerOrderItem.cannedFruit = { "id": parsedItem.id } as CannedFruit;
      customerOrderItem.cnt = parsedItem.cnt;
      return customerOrderItem;
    });
    const customerOrder = new CustomerOrder();
    customerOrder.customer = { id: customerId } as Customer;
    customerOrder.nameOnCard = submittedForm.nameOnCard;
    customerOrder.cardNbr = submittedForm.cardNbr;
    customerOrder.expirationDt = this.formatExpirationDt(submittedForm.expirationDt);
    customerOrder.cvv = submittedForm.cvv;
    customerOrder.orderStatus = 'NEW';
    customerOrder.customerOrderItems = customerOrderItems;
    customerOrder.shipping = { "id": JSON.parse(submittedForm.shippingRadios).id } as Shipping;
    customerOrder.shipToAddress = { "id": JSON.parse(submittedForm.addrRadios).id } as ShipToAddress;
    return customerOrder;
  }

  formatExpirationDt(expirationDt: string): string {
    //console.log("formatExpirationDt: expirationDt", expirationDt); ///////
    let expDt = '';
    let components = expirationDt.split("/");
    const currCentury = "20";
    console.log("formatExpirationDt: components", components.length); ///////
    if (components.length === 2) {
      let month = components[0].trim();
      let year = components[1].trim();
      if (year.length === 2) {
        year = currCentury + year; // pad two digit year with leading 20
      }
      const mthNbr = Number(month); // the months run from Feb of this year to Jan of next year
      const yrNbr = Number(year); // + (mthNbr === 12 ? 1 : 0); // if month is Jan, increment year
      expDt = new Date(yrNbr, mthNbr, 1).toLocaleDateString("en-CA"); // last day of month
    }
    return expDt;
  }

  calcTotalCosts(OrderForm: any, lastAddrRadio: any | null, lastShippingRadio: any | null): number {
    let state = lastAddrRadio ? lastAddrRadio.state : OrderForm.addrRadios.state;
    let shippingPrice = lastShippingRadio ? lastShippingRadio.price : OrderForm.shippingRadios.price;
    let totalCost = 0;
    let shippingCost = 0;
    let totalItemCost = 0;
    let totalVolume = 0;
    const salesTaxRate = this.determineTaxRate(state);
    OrderForm.cntItems.forEach((item: any) => {
      item = JSON.parse(item);
      totalItemCost += item.volume * item.pricePer * item.cnt * (1 + salesTaxRate);
      totalVolume += item.volume * item.cnt;
    });
    shippingCost = shippingPrice * totalVolume;
    totalCost = totalItemCost + shippingCost;
    return totalCost;
  }

  determineTaxRate(state: string): number {
    let taxRate = 0;
    const stateTax = STATE_TAX_RATES.find(item => item.state === state);
    if (stateTax) {
      taxRate = stateTax.rate;
    }
    return taxRate;
  }
}
/*
{
  "addrRadios": "{ id: 8, state: NC }",
  "shippingRadios": "{ id: 152, price: 0.14 }",
  "cntItems": [
      "{ id:6, cnt:36, volume:8, pricePer:0.47}",
      "{ id:112, cnt:96, volume:8, pricePer:0.43}",
      "{ id:8, cnt:24, volume:16, pricePer:0.93}"
  ],
  "nameOnCard": "MARY PICKFORD",
  "cardNbr": "4111111111111111",
  "expirationDt": "12/27",
  "cvv": "123"
}
  */