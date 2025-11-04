import { Inject, Injectable } from "@angular/core";
import { Medium } from "./medium";
import { CannedFruit } from "./cannedFruit";

@Injectable()
export class CustomerOrderItem {
  id!: number;
  cannedFruit!: CannedFruit;
  cnt!: number;
  constructor(
    @Inject(Number) id: number,
    @Inject(CannedFruit) cannedFruit: CannedFruit,
    @Inject(Number) cnt: number
  ) {
    this.id = id;
    this.cannedFruit = cannedFruit;
    this.cnt = cnt;
  }
}