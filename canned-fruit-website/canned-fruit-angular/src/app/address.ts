import { Injectable, Inject } from "@angular/core";

@Injectable()
export class Address {
  id!: number;
  addrType!: string;
  street1!: string;
  street2!: string;
  city!: string;
  state!: string;
  zip!: string;
  constructor(@Inject(Number) id: number, @Inject(String) addrType: string, @Inject(String) street1: string, @Inject(String) street2: string, @Inject(String) city: string, @Inject(String) state: string, @Inject(String) zip: string) {
    this.id = id;
    this.addrType = addrType;
    this.street1 = street1;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }
  /* export class Address {
    id!: number;
    addrType!: string;
    street1!: string;
    street2!: string;
    city!: string;
    state!: string;
    zip!: string;
    constructor(id: number, addrType: string, street1: string, street2: string, city: string, state: string, zip: string) {
      this.id = id;
      this.addrType = addrType;
      this.street1 = street1;
      this.street2 = street2;
      this.city = city;
      this.state = state;
      this.zip = zip;
    } */
}