import { AfterViewInit, Component, NgModule, OnInit, ViewChild, WritableSignal, signal } from '@angular/core';

import { Observable } from 'rxjs';
import { CannedFruitService } from '../canned-fruit.service';
import { CannedFruit } from '../cannedFruit';
import { FormGroup, FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Medium } from '../medium';
import { Router, RouterModule } from '@angular/router';
import { MatSortModule, Sort } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cannedFruit',
  templateUrl: './list-cannedFruit.component.html',
  styleUrls: ['./list-cannedFruit.component.css'],
  standalone: true,
  imports: [MatTableModule, MatSortModule, FormsModule, CommonModule, ReactiveFormsModule, RouterModule],
})

export class ListCannedFruitComponent implements OnInit {
  cannedFruits: CannedFruit[] = [];
  selectedFruit: string = '';
  fruits!: string[];
  sortedData: WritableSignal<CannedFruit[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  //@ViewChild(MatSortModule) sort!: MatSortModule;

  constructor(private router: Router, public cannedFruitSvc: CannedFruitService) { }
  selectedOption: string = '';
  myForm2 = new FormGroup({
    cannedFruitSelection: new FormControl(''),
  });

  async ngOnInit(): Promise<void> {
    console.log("Sandbox ngOnInit"); ////////
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getCannedFruits().subscribe(data => {
        this.cannedFruits = data.slice();
        resolve();
      });
    });
    //TODO make it getDistinctFruitsLocal
    //this.fruits = this.cannedFruitSvc.getDistinctFruits()
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getDistinctFruits().subscribe(data => {
        console.log("distinct fruits data: " + data); ////////
        this.fruits = data.slice();
        resolve();
      });
    });
    //this.sortedData = this.cannedFruits.slice();
    console.log("fruits: " + this.fruits); ////////
    if (this.fruits && this.fruits.length > 0) {
      this.selectedOption = "all";
      this.getCannedFruitsByFruit(this.selectedOption);
    }
  }
  setFruitFilter(formValue: any) {
    this.selectedFruit = formValue.mySelect;
    console.log(formValue.mySelect);
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