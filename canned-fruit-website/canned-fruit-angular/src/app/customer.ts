import { Injectable, Inject } from "@angular/core";
import { Address } from "./address";

@Injectable()
export class Customer {
	id!: number;
	businessName!: string;
	outletName!: string;
	pocFirst!: string;
	pocLast!: string;
	pocPhone!: string;
	pocEmail!: string;
	addresses!: Address[];
	constructor(@Inject(Number) id: number, @Inject(String) businessName: string, @Inject(String) outletName: string, @Inject(String) pocFirst: string, @Inject(String) pocLast: string, @Inject(String) pocPhone: string, @Inject(String) pocEmail: string, @Inject(Address) addresses: Address[]) {
		this.id = id;
		this.businessName = businessName;
		this.outletName = outletName;
		this.pocFirst = pocFirst;
		this.pocLast = pocLast;
		this.pocPhone = pocPhone;
		this.pocEmail = pocEmail;
		this.addresses = addresses;
	}
}
/*export class Customer {
	id!: number;
	businessName!: string;
	outletName!: string;
	pocFirst!: string;
	pocLast!: string;
	pocPhone!: string;
	pocEmail!: string;
	addresses!: Address[];
	constructor(id: number, businessName: string, outletName: string, pocFirst: string, pocLast: string, pocPhone: string, pocEmail: string, addresses: Address[]) {
		this.id = id;
		this.businessName = businessName;
		this.outletName = outletName;
		this.pocFirst = pocFirst;
		this.pocLast = pocLast;
		this.pocPhone = pocPhone;
		this.pocEmail = pocEmail;
		this.addresses = addresses;
	}
}*/