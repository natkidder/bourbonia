import { Inject, Injectable } from "@angular/core";
import { Medium } from "./medium";

@Injectable()
export class AbbrevCannedFruit {
  id!: number;
  fruit!: string;
  constructor(
    @Inject(Number) id: number,
    @Inject(String) fruit: string,
  ) {
    this.id = id;
    this.fruit = fruit;
  }
}