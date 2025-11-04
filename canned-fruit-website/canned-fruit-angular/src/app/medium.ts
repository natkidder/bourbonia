import { Injectable, Inject } from "@angular/core";

@Injectable()
export class Medium {
  id!: number;
  mediumName!: string;
  constructor(@Inject(Number) id: number, @Inject(String) mediumName: string) {
    this.id = id;
    this.mediumName = mediumName;
  }
}