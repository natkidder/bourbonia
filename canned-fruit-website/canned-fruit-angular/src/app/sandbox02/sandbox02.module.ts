import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Sandbox02Component } from './sandbox02.component';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatTableModule } from '@angular/material/table';
import { AppModule } from '../app.module';

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
    bootstrap: [Sandbox02Component]
})

export class Sandbox02Module { }