import { Component, ChangeDetectionStrategy, ChangeDetectorRef, WritableSignal, signal } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CannedFruitService } from '../canned-fruit.service';
import { CannedFruit } from '../cannedFruit';
import { AbbrevCannedFruit } from '../abbrevCannedFruit';
import { Router, RouterLink } from '@angular/router';
import { Sort, MatSortModule } from '@angular/material/sort';

@Component({
  selector: 'app-check-box-example',
  templateUrl: './del-cannedFruit.component.html',
  styleUrls: ['./del-cannedFruit.component.css'],
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink, MatSortModule],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DelCannedFruitComponent {
  isUpdating: boolean = false;
  myForm4: FormGroup;
  myForm: FormGroup<{ fruitSelection: FormControl<string | null> }>;
  selectedIds: number[] = [];
  cannedFruits: CannedFruit[] = [];
  abbrevCannedFruits: AbbrevCannedFruit[] = [];
  sortedData: WritableSignal<CannedFruit[]> = signal([]);
  lastSortDirection: WritableSignal<string> = signal('');
  isChecked: boolean | null = false; // Property to store the selected checkbox value
  joinedIds: number[] = [];
  distinctFruits: { fruit: string }[] = [];
  distinctFruitsMenu: WritableSignal<{ fruit: string }[]> = signal([]);
  showMyForm4: WritableSignal<boolean> = signal(false);
  readonly ALL_FRUITS_OPTION: string = '--All--';
  //readonly ALL_FRUITS_ARG: string = '';
  constructor(private formBuilder: FormBuilder, public cannedFruitSvc: CannedFruitService, private cdr: ChangeDetectorRef) {
    this.myForm = new FormGroup({
      fruitSelection: new FormControl(this.ALL_FRUITS_OPTION, Validators.required)
    });
    this.myForm4 = this.formBuilder.group({
      selectedItems: this.formBuilder.array([]) // Initialize an empty FormArray
    });
    this.addCheckboxes();
  }
  async ngOnInit(): Promise<void> {
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getCannedFruitsNoOrders('').subscribe((data) => {
        this.abbrevCannedFruits = data;
        resolve();
      });
    });
    const abcs2 = this.abbrevCannedFruits.map(item => item.fruit)
      .reduce((acc, curr) => {
        acc[curr] = (acc[curr] || 0) + 1;
        return acc;
      }, {} as { [key: string]: number });
    this.distinctFruits = Object.keys(abcs2).map(fruit => ({ fruit }));
    this.distinctFruits.push({ fruit: this.ALL_FRUITS_OPTION });
    this.distinctFruits.sort((a, b) => a.fruit.localeCompare(b.fruit));
    this.distinctFruitsMenu.update(() => this.distinctFruits);
    console.log('ngOnInit distinctFruits: ', this.distinctFruits); /////////
  }

  async setupForm(): Promise<void> {

    //this.namedParams = '?id=';
    let ids2: number[] = [];
    var selectedFruit: any;
    await new Promise<void>((resolve) => {
      if (this.myForm.valid) {
        selectedFruit = this.myForm.value.fruitSelection;
      } else {
        selectedFruit = this.ALL_FRUITS_OPTION;
      }
      resolve();
      console.log('selectedFruit 01:', selectedFruit); //////////
    });
    //console.log('selectedFruit 02:', selectedFruit);

    if (selectedFruit && selectedFruit !== this.ALL_FRUITS_OPTION) {
      let i = 0;
      this.abbrevCannedFruits
        .filter(cf => cf.fruit === selectedFruit)
        .map(cf => {
          ids2.push(cf.id);
          i++;
        });
    } else {
      this.abbrevCannedFruits.map((abbrevCannedFruit) => {
        ids2.push(abbrevCannedFruit.id);
      });
    }
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getCannedFruitsByIdList(ids2).subscribe((data) => {
        this.cannedFruits = data;
        this.sortedData.set(this.cannedFruits.slice());
        resolve();
      });
    });
    (this.myForm4.get('selectedItems') as FormArray).clear();
    // Add new checkboxes based on the updated cannedFruits list
    this.addCheckboxes();
    if (this.cannedFruits.length > 0) {
      this.showMyForm4.set(true);
      //this.cdr.detectChanges();
    } else {
      this.showMyForm4.set(false);
      //this.cdr.detectChanges();
    }
    console.log('showMyForm4 02:', this.showMyForm4);
  }
  addCheckboxes() {
    this.cannedFruits.forEach(() => this.selectedItems.push(new FormControl(false)));
  }

  get selectedItems() {
    return this.myForm4.get('selectedItems') as FormArray;
  }

  getSelectedItemsIds() {
    this.selectedIds = this.myForm4.value.selectedItems
      .map((checked: boolean, i: number) => checked ? this.cannedFruits[i].id : null)
      .filter((id: number | null) => id !== null);
    return this.selectedIds;
  }

  onSubmit() {
    if (!confirm('Are you sure you want to remove the selected canned fruit offerings?')) {
      return
    }
    console.log('onSubmit selectedIds: ', this.getSelectedItemsIds());
    this.getSelectedItemsIds().map((id) => {
      console.log('Removing cannedFruit id: ', id);
      this.cannedFruitSvc.deleteCannedFruit(id).subscribe(
        (response) => {
          console.log('CannedFruit deleted successfully:', response);
          this.cannedFruits = this.cannedFruits.filter(cannedFruit => cannedFruit.id !== id);
          this.sortedData.set(this.cannedFruits.slice());
          // Also need to update the form array to remove the corresponding checkbox
          const index = this.cannedFruits.findIndex(cannedFruit => cannedFruit.id === id);
          if (index !== -1) {
            (this.myForm4.get('selectedItems') as FormArray).removeAt(index);
          }
        },
        (error) => {
          console.error('Error removing cannedFruit ' + id + ': ', error);
        }
      )
    });
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
