import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from '../app.component';
import { HttpClientModule } from '@angular/common/http';
import { AddSelfCustomerComponent } from './add-selfCustomer.component';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
    ],
    declarations: [
        //AddSelfCustomerComponent // you cannot have more than one module declare a component, and AddSelfCustomerComponent is declared in AppModule
    ],
    //bootstrap: [AddSelfCustomerComponent]
})

export class SelfCustomerModule { }