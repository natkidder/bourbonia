import { Routes } from '@angular/router';
import { MainLinksComponent } from './main-links/main-links.component';
import { LoginComponent } from './login/login.component';
import { SandboxComponent } from './sandbox/sandbox.component';
import { Sandbox02Component } from './sandbox02/sandbox02.component';
import { ShippingComponent } from './shipping/shipping.component';
import { DeleteShippingComponent } from './delete-shipping/delete-shipping.component';
import { AddShippingComponent } from './add-shipping/add-shipping.component';
import { AddCannedFruitComponent } from './add-cannedFruit/add-cannedFruit.component';
import { AddCustOrderComponent } from './add-custOrder/add-custOrder.component';
import { AddSelfCustomerComponent } from './add-selfCustomer/add-selfCustomer.component';
import { DelCannedFruitComponent } from './del-cannedFruit/del-cannedFruit.component';
import { DelCustomerComponent } from './del-customer/del-customer.component';
import { ListCannedFruitComponent } from './list-cannedFruit/list-cannedFruit.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { UpdCannedFruitComponent } from './upd-cannedFruit/upd-cannedFruit.component';
import { UpdCustomerComponent } from './upd-customer/upd-customer.component';
import { UpdShippingComponent } from './upd-shipping/upd-shipping.component';

export const routes: Routes = [
    { path: '', component: LoginComponent }
    , { path: 'addCannedFruit', component: AddCannedFruitComponent }
    , { path: 'addCustOrder', component: AddCustOrderComponent }
    , { path: 'addSelfCustomer', component: AddSelfCustomerComponent }
    , { path: 'addShipping', component: AddShippingComponent }
    , { path: 'businessAdmin', component: MainLinksComponent }
    , { path: 'delCustomer', component: DelCustomerComponent }
    , { path: 'deleteCannedFruit', component: DelCannedFruitComponent }
    , { path: 'deleteShipping', component: DeleteShippingComponent }
    , { path: 'listCannedFruit', component: ListCannedFruitComponent }
    , { path: 'listCustomer', component: ListCustomerComponent }
    , { path: 'listShipping', component: ShippingComponent }
    , { path: 'sandbox', component: SandboxComponent }
    , { path: 'sandbox02', component: Sandbox02Component }
    , { path: 'updCannedFruit', component: UpdCannedFruitComponent }
    , { path: 'updCustomer', component: UpdCustomerComponent }
    , { path: 'updShipping', component: UpdShippingComponent }
];
