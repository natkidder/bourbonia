import { AfterViewInit, Component, NgModule, OnInit, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef, WritableSignal, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerService } from '../customer-svc.service';
import { Customer } from '../customer';
import { Address } from '../address';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CannedFruitService } from '../canned-fruit.service';
import { CannedFruit } from '../cannedFruit';
import { AbbrevCannedFruit } from '../abbrevCannedFruit';
import { Medium } from '../medium';
import { CommonModule } from '@angular/common';
import { Sort, MatSortModule } from '@angular/material/sort';

@Component({
  // selector finds an element in the corresponding HTML entirty (element, attribute, etc.)
  selector: 'app-upd-cannedFruit',
  templateUrl: './upd-cannedFruit.component.html',
  styleUrls: ['./upd-cannedFruit.component.css'],
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [ReactiveFormsModule, CommonModule, FormsModule, RouterLink, MatSortModule]
})
export class UpdCannedFruitComponent implements OnInit {
  isUpdating: boolean = false;
  myForm4: FormGroup;
  myForm: FormGroup<{ fruitSelection: FormControl<string | null> }>;
  myForm5: FormGroup;
  selectedFruit: string = '';
  fruits!: string[];
  selectedIds: number[] = [];
  cannedFruits: CannedFruit[] = [];
  abbrevCannedFruits: AbbrevCannedFruit[] = [];
  selectedCannedFruit: CannedFruit | null = null;
  sortedData: WritableSignal<CannedFruit[]> = signal([]);
  showMyForm4: WritableSignal<boolean> = signal(false);
  lastSortDirection: WritableSignal<string> = signal('');
  joinedIds: number[] = [];
  distinctFruits: string[] = [];
  mediums: Medium[] = [];
  selectedOption: string | null = null; // Property to store the selected radio button value
  readonly ALL_FRUITS_OPTION: string = '--All--';
  i: any;
  //readonly ALL_FRUITS_ARG: string = '';
  constructor(private formBuilder: FormBuilder, public cannedFruitSvc: CannedFruitService, private cdr: ChangeDetectorRef, private router: Router) {
    this.myForm = new FormGroup({
      fruitSelection: new FormControl(this.ALL_FRUITS_OPTION, Validators.required)
    });
    this.myForm4 = this.formBuilder.group({
      selectedItems: this.formBuilder.array([]) // Initialize an empty FormArray
    });
    this.myForm5 = this.formBuilder.group({
      // Other controls in your main form group
      id: [''],
      fruit: ['', Validators.required],
      mediumSelection: ['', Validators.required],
      unitType: ['', Validators.required],
      volume: ['', [Validators.required, Validators.min(0)]],
      container: ['', Validators.required],
      pricePer: ['', [Validators.required, Validators.min(0)]],
    });
  }
  async ngOnInit(): Promise<void> {
    this.mediums = await this.cannedFruitSvc.getMediums2().toPromise() || [];
    console.log('ngOnInit mediums: ', this.mediums);
    await new Promise<void>((resolve) => {
      this.cannedFruitSvc.getDistinctFruits().subscribe((data) => {
        this.distinctFruits = data;
        resolve();
      });
    });
    this.distinctFruits.push(this.ALL_FRUITS_OPTION);
    this.distinctFruits.sort((a, b) => a.localeCompare(b));
    this.cdr.detectChanges();
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

  async setupForm(): Promise<void> {
    //this.namedParams = '?id=';
    var selectedFruit: any;
    await new Promise<void>((resolve) => {
      if (this.myForm.valid) {
        selectedFruit = this.myForm.value.fruitSelection;
      } else {
      } resolve();
    });

    if (selectedFruit && selectedFruit !== this.ALL_FRUITS_OPTION) {
      await new Promise<void>((resolve) => {
        this.cannedFruitSvc.getCannedFruitsByFruit(selectedFruit).subscribe((data) => {
          this.cannedFruits = data;
          resolve();
        });
      });
    } else {
      await new Promise<void>((resolve) => {
        this.cannedFruitSvc.getCannedFruits().subscribe((data) => {
          this.cannedFruits = data;
          resolve();
        });
      });
    }
    this.sortedData.set(this.cannedFruits.slice());
    if (this.cannedFruits.length > 0) {
      this.showMyForm4.set(true);
    } else {
      this.showMyForm4.set(false);
    }
  }

  isOptionSelected(): boolean {
    return this.selectedOption !== null;
  }

  async setUpdCannedFruit(formInput: any) {
    console.log('customerID: ', formInput.updRadios); ////////
    if (formInput.updRadios) {
      const cannedFruitID: number = +formInput.updRadios;
      // TODO: deal with null medium
      this.selectedCannedFruit = (await this.cannedFruitSvc.getOneCannedFruit(cannedFruitID).toPromise()) ?? null;
      console.log('this.selectedCannedFruit: ', this.selectedCannedFruit);
      this.myForm5.reset();
      //this.myForm5.addresses.clear();
      if (this.selectedCannedFruit) {
        console.log('Patching form with medium:', this.selectedCannedFruit.medium.mediumName); ////////
        this.myForm5.patchValue({
          id: this.selectedCannedFruit.id,
          fruit: this.selectedCannedFruit.fruit,
          mediumSelection: this.selectedCannedFruit.medium == null ? '' : this.selectedCannedFruit.medium.mediumName,
          unitType: this.selectedCannedFruit.unitType,
          volume: this.selectedCannedFruit.volume,
          container: this.selectedCannedFruit.container,
          pricePer: this.selectedCannedFruit.pricePer
        });
      }
    }
  }
  onForm5Submit() {
    if (!this.isUpdating) {
      console.log('Form Submitted');
      console.log(this.myForm5.value);
      this.selectedCannedFruit = this.responseToCannedFruit(this.myForm5.value);
      this.cannedFruitSvc.updCannedFruit(this.selectedCannedFruit).subscribe(
        (response) => {
          if (response.hasOwnProperty('id')) {
            alert('CannedFruit Nbr  ' + (response as any).id + ' successfully updated');
            console.log('cannedFruit added successfully:', response);
            const id = (response as any).id;
            let origCannedFruit = this.cannedFruits.filter(cannedFruit => cannedFruit.id === id);
            if (origCannedFruit && this.selectedCannedFruit) {
              Object.assign(origCannedFruit[0], this.selectedCannedFruit);
            }
            //this.selectedOption = null; // Clear the selected radio button 
            this.myForm5.reset();
          } else {
            console.error('Unexpected response format:', response);
          }
        },
        (error) => {
          console.error('Error updating cannedFruit:', error);
        }
      );
    }
    this.isUpdating = false;
  }
  responseToCannedFruit(response: any): CannedFruit {
    let cannedFruit: CannedFruit = {} as CannedFruit;
    console.log('responseToCannedFruit response:', response); ////////
    cannedFruit.id = response.id;
    cannedFruit.fruit = response.fruit;
    cannedFruit.medium = this.cannedFruitSvc.getMediumByName(response.mediumSelection, this.mediums);
    cannedFruit.unitType = response.unitType;
    cannedFruit.volume = response.volume;
    cannedFruit.container = response.container;
    cannedFruit.pricePer = response.pricePer;
    return cannedFruit;
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
