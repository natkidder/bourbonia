import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { SandboxComponent } from './sandbox/sandbox.component';
import { Sandbox02Component } from './sandbox02/sandbox02.component';
import { ShippingComponent } from './shipping/shipping.component';
import { DeleteShippingComponent } from './delete-shipping/delete-shipping.component';
import { AddShippingComponent } from './add-shipping/add-shipping.component';
import { UpdShippingComponent } from './upd-shipping/upd-shipping.component';
import { MainLinksComponent } from './main-links/main-links.component';
import { ListCannedFruitComponent } from './list-cannedFruit/list-cannedFruit.component';
import { DelCannedFruitComponent } from './del-cannedFruit/del-cannedFruit.component';
import { AddCannedFruitComponent } from './add-cannedFruit/add-cannedFruit.component';
import { UpdCannedFruitComponent } from './upd-cannedFruit/upd-cannedFruit.component';
import { AddSelfCustomerComponent } from './add-selfCustomer/add-selfCustomer.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { UpdCustomerComponent } from './upd-customer/upd-customer.component';
import { DelCustomerComponent } from './del-customer/del-customer.component';
import { AddCustOrderComponent } from './add-custOrder/add-custOrder.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      /* { path: 'businessAdmin', component: MainLinksComponent },
      { path: 'sandbox', component: SandboxComponent },
      { path: 'sandbox02', component: Sandbox02Component },
      { path: 'shipping', component: ShippingComponent },
      { path: 'deleteShipping', component: DeleteShippingComponent },
      { path: 'addShipping', component: AddShippingComponent },
      { path: 'updShipping', component: UpdShippingComponent },
      { path: 'listCannedFruit', component: ListCannedFruitComponent },
      { path: 'deleteCannedFruit', component: DelCannedFruitComponent },
      { path: 'addCannedFruit', component: AddCannedFruitComponent },
      { path: 'updCannedFruit', component: UpdCannedFruitComponent },
      { path: 'addSelfCustomer', component: AddSelfCustomerComponent },
      { path: 'listCustomer', component: ListCustomerComponent },
      { path: 'updCustomer', component: UpdCustomerComponent },
      { path: 'delCustomer', component: DelCustomerComponent },
      { path: 'addCustOrder', component: AddCustOrderComponent } */
    ])
  ],
  declarations: [
    TopBarComponent,
  ],
  bootstrap: [
  ]
})
export class AppModule { }

/*
AddCannedFruitComponent,
AddSelfCustomerComponent,
AddShippingComponent,
AppComponent
AppComponent,
DelCannedFruitComponent,
DelCustomerComponent,
DeleteShippingComponent,
ListCannedFruitComponent,
ListCustomerComponent,
MainLinksComponent,
Sandbox02Component,
SandboxComponent,
ShippingComponent,
UpdCannedFruitComponent,
UpdCustomerComponent,
UpdShippingComponent,
*/
