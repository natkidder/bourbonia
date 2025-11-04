import { Component, ChangeDetectionStrategy, ChangeDetectorRef, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { Customer } from '../customer';
import { CustomerService } from '../customer-svc.service';
import { RouterModule, RouterOutlet, Router } from '@angular/router';
import { AddCannedFruitComponent } from "../add-cannedFruit/add-cannedFruit.component";

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [CommonModule, ReactiveFormsModule, RouterModule, RouterOutlet],
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css', '../app.css'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComponent implements OnInit {
    myForm: FormGroup;
    customers: Customer[] = [];
    readonly ADMIN_EMAIL: string = 'admin@cannedFruit.com';
    customerEmail: string = '';
    showError: boolean = false;

    constructor(private fb: FormBuilder, private cdr: ChangeDetectorRef, private customerSvc: CustomerService, private router: Router) {
        this.myForm = this.fb.group({
            customerPocEmail: ['', [Validators.required, Validators.email]]
        });
    }
    ngOnInit(): void {
        console.log('LoginComponent initialized');
    }
    async onSubmitMyForm() {
        console.log('Form Submitted!', this.myForm.value); /////////
        this.customerEmail = this.myForm.value.customerPocEmail;
        console.log('Submitted email:', this.customerEmail);
        if (this.customerEmail === this.ADMIN_EMAIL) {
            console.log('Navigating to admin view'); ////////////
            // TODO: make the parameters read from a file or database
            this.router.navigate(['/businessAdmin'],
                { queryParams: { isVisibleSandbox: true, canAddCustomer: false } }
            );
            return;
        }
        await new Promise<void>((resolve) => {
            this.customerSvc.getCustomerByEmail(this.customerEmail).subscribe((data) => {
                if (data) {
                    console.log('customer found with email:', this.customerEmail);
                    this.customers = data ? [data] : [];
                    this.showError = this.customers.length === 0;
                    console.log('submitMyForm - showError:', this.showError); /////////
                    this.cdr.detectChanges();
                    resolve();
                } else {
                    console.error('Error fetching customer data:', Error);
                    this.customers = [];
                    resolve();
                }
            }, (error: any) => {
                console.error('Error fetching customer data:', error);
                this.customers = [];
                this.cdr.detectChanges();
                this.showError = true;
                console.log('submitMyForm - showError:', this.showError); /////////
                this.cdr.detectChanges();
                resolve();
            });
        });
        const customer = this.customers.length > 0 ? this.customers[0] : null;
        if (customer) {
            console.log('Navigating to showCustomer with customer:', customer);
            // Simulate a delay to ensure the data is ready before navigation
            //await new Promise((r) => setTimeout(r, 1000));
            //alert('TODO: change routing from sandbox to addCustOrder.'); /////////S
            //this.router.navigate(['/sandbox'], {
            this.router.navigate(['/addCustOrder'], {
                queryParams: { customer: this.customers.length > 0 ? JSON.stringify(this.customers) : '' }
            });
        } else {
            console.warn('No customer found, staying on login page');
        }
    }
}
