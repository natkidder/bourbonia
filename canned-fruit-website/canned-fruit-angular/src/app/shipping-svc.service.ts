import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shipping } from './shippings';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShippingSvcService {

  constructor(private http: HttpClient) { }
  shippings: Shipping[] = [];

  // TODO change ShippingPrice to Shipping
  getOneShippingPrice(id: number) {
    return this.http.get<Shipping>('http://localhost:8081/api2/shipping/' + id);
  }
  getShippingsByIdList(ids: number[]): Observable<Shipping[]> {
    let namedParams = this.arrayToNamedParams(ids);
    return this.http.get<Shipping[]>('http://localhost:8081/api2/shippingIdCollection' + namedParams, { withCredentials: true });
  }
  getShippingPrices(): Observable<Shipping[]> {
    return this.http.get<Shipping[]>('http://localhost:8081/api2/shipping');
  }
  getShippingNoOrders() {
    return this.http.get<{ id: number }[]>('http://localhost:8081/api2/shippingNoOrders');
  }
  addShippingPrice(shipping: { type: string, price: number }) {
    return this.http.post('http://localhost:8081/api2/shipping', shipping);
  }
  updShippingPrice(shipping: Shipping) {
    console.log("updShippingPrice: Shipping id:" + shipping.id);
    return this.http.put('http://localhost:8081/api2/shipping/' + shipping.id, shipping);
  }
  deleteShippingPrice(id: number) {
    return this.http.delete('http://localhost:8081/api2/shipping/' + id);
  }

  public arrayToNamedParams(ids: number[]): string {
    return '?id=' + [...ids].join('&id=');
  }
}
