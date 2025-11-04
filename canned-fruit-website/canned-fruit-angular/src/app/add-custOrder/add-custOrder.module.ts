import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { AppModule } from '../app.module';
import { AddCustOrderComponent } from './add-custOrder.component';

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
    exports: [MatTableModule, MatSortModule, MatSort]
    //bootstrap: [AddCustOrderComponent]
})

export class AddCustOrderModule { }