import { Inject, Injectable } from "@angular/core";

@Injectable()
export class Shipping {
  id!: number;
  type!: string;
  price!: number;
  constructor(@Inject(Number) id: number, @Inject(String) type: string, @Inject(Number) price: number) {
    this.id = id;
    this.type = type;
    this.price = price;
  }
}