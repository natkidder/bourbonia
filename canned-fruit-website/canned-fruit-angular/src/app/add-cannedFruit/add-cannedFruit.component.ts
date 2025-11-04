import { Component, OnInit, NgModule, WritableSignal, signal, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { BrowserModule } from '@angular/platform-browser';
import { FormGroup, FormControl } from '@angular/forms';
import { Observable, of } from 'rxjs';
import { CannedFruitService } from '../canned-fruit.service';
import { Router, RouterModule } from '@angular/router';
import { CannedFruit } from '../cannedFruit';
import { CommonModule } from '@angular/common';
import { Medium } from '../medium';
import * as derivedMediums from '../../assets/mediums.json';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';

@Component({
  // selector finds an element in the corresponding HTML entirty (element, attribute, etc.)
  selector: 'app-add-cannedFruit',
  templateUrl: './add-cannedFruit.component.html',
  styleUrls: ['./add-cannedFruit.component.css'],
  standalone: true,
  imports: [MatTableModule, MatSortModule, CommonModule, FormsModule, RouterModule]
})
export class AddCannedFruitComponent implements OnInit {
  cannedFruits!: CannedFruit[];
  mediums!: Medium[];
  sortedData: WritableSignal<CannedFruit[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  selectedFruit: string = '';
  fruits!: string[];
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private router: Router,
    public cannedFruitSvc: CannedFruitService
  ) { }

  async ngOnInit(): Promise<void> {
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getCannedFruits().subscribe(data => {
        this.cannedFruits = data.slice();
        resolve();
      });
    });
    console.log('ngOnInit: after getCannedFruits');
    //this.mediums = of(derivedMediums); 
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getMediums2().subscribe(data => {
        this.mediums = data.slice();
        resolve();
      });
    });
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getDistinctFruits().subscribe(data => {
        this.fruits = data.slice();
        this.selectedOption = "all";
        resolve();
      });
    });

    console.log("ngOnInit: after getMediums"); //////////////////////
  }
  selectedOption: string = '';
  myForm = new FormGroup({
    cannedFruitSelection: new FormControl(''),
  });

  async getMediums(): Promise<Medium[]> {
    const mediums: Medium[] = [];
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getMediums2().subscribe(data => {
        mediums.push(...data);
        resolve();
      });
    });
    return mediums;
  }

  getMedium(mediumId: number): Medium {
    let foundMedium: Medium = {} as Medium;
    this.getMediums().then(mediumsArray => {
      foundMedium = mediumsArray.find(medium => medium.id - mediumId === 0) as Medium;
      console.log('Found medium 01:', JSON.stringify(foundMedium));
    });

    console.log('Found medium 02:', JSON.stringify(foundMedium));
    return new Medium(foundMedium.id, foundMedium.mediumName);
  }
  setFruitFilter(formValue: any) {
    this.selectedFruit = formValue.mySelect;
    console.log(formValue.mySelect); ///////////////////
    this.getCannedFruitsByFruit(formValue.mySelect);
    this.router.navigate([this.router.url]); // refresh the page
  }
  async getCannedFruitsByFruit(fruit: string) {
    if (fruit === 'all') {
      await new Promise<void>((resolve) => {
        this.cannedFruitSvc.getCannedFruits().subscribe(data => {
          this.cannedFruits = data.slice();
          resolve();
        });
      });
    } else {
      await new Promise<void>((resolve) => {
        this.cannedFruitSvc.getCannedFruitsByFruit(fruit).subscribe(data => {
          this.cannedFruits = data.slice();
          resolve();
        });
      });
    }
    this.sortedData.set(this.cannedFruits.slice());
    console.log('sortedData after getCannedFruitsByFruit:', JSON.stringify(this.sortedData())); ///////////////////
  }

  // This method is called when the form is submitted
  onSubmit(formValue: any) {
    console.log('Form after setting medium:', JSON.stringify(formValue));
    this.addCannedFruit(formValue, formValue.mediumId);
    this.router.navigate([this.router.url]);
  }

  async addCannedFruit(formValue: any, mediumId: number) {
    const mediumsArray = this.mediums;
    let foundMedium = mediumsArray.find(medium => medium.id - mediumId === 0) as Medium;
    console.log('Found medium 01:', JSON.stringify(foundMedium));
    delete formValue.mediumId;
    console.log('Form after deleting mediumId:', JSON.stringify(formValue));
    let newCannedFruit = new CannedFruit(
      formValue.id,
      formValue.fruit,
      new Medium(foundMedium.id, foundMedium.mediumName),
      formValue.unitType,
      formValue.volume,
      formValue.container,
      formValue.pricePer
    );
    console.log('Found medium 02:', JSON.stringify(newCannedFruit.medium)); //////////
    console.log('newCannedFruit 03:', JSON.stringify(newCannedFruit)); //////////
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.addCannedFruit(newCannedFruit).subscribe(
        (response) => {
          console.log('CannedFruit added successfully:', response);
          newCannedFruit = response as CannedFruit;
          console.log('newCannedFruit after addn & reassignment:', newCannedFruit);
          // Optionally, refresh the cannedFruit costs after addition
          resolve();
        });
    });
    this.sortedData.update((items: any) => [...items, newCannedFruit]);
  }
  sortData(sort: Sort) {
    const data = this.cannedFruits.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData.set(data);
      sort.direction = this.lastSortDirection() === 'asc' ? 'desc' : 'asc';
    }
    this.sortedData.set(data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'fruit':
          return compare(a.fruit, b.fruit, isAsc);
        case 'medium':
          return compare(a.medium.mediumName, b.medium.mediumName, isAsc);
        case 'preparation':
          return compare(a.unitType, b.unitType, isAsc);
        case 'volume':
          return compare(a.volume, b.volume, isAsc);
        case 'container':
          return compare(a.container, b.container, isAsc);
        case 'pricePer':
          return compare(a.pricePer, b.pricePer, isAsc);
        default:
          return 0;
      }
      this.lastSortDirection.set(sort.direction !== '' ? sort.direction : this.lastSortDirection());
    }));
  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
