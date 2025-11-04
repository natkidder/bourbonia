import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { UpdCustomerComponent } from './upd-customer.component';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@NgModule({
    declarations: [
        // your components here
    ],
    imports: [
        CommonModule,
        MatTableModule,
        MatSortModule,
        MatSort
        // other modules here
    ],
    providers: [],
    exports: [MatTableModule, MatSortModule, MatSort],
    //bootstrap: [UpdCustomerComponent]
})

export class UpdCustomerModule { }