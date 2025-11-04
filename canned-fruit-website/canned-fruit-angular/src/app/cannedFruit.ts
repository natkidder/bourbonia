import { Inject, Injectable } from "@angular/core";
import { Medium } from "./medium";

@Injectable()
export class CannedFruit {
  id!: number;
  fruit!: string;
  medium!: Medium;
  unitType!: string;
  volume!: number;
  container!: string;
  pricePer!: number;

  constructor(
    @Inject(Number) id: number,
    @Inject(String) fruit: string,
    @Inject(Medium) medium: Medium,
    @Inject(String) unitType: string,
    @Inject(Number) volume: number,
    @Inject(String) container: string,
    @Inject(Number) pricePer: number
  ) {
    this.id = id;
    this.fruit = fruit;
    this.medium = medium;
    this.unitType = unitType;
    this.volume = volume;
    this.container = container;
    this.pricePer = pricePer;
  }
}