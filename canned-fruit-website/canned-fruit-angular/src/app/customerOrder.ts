import { Injectable, Inject } from "@angular/core";
import { Address } from "./address";
import { Customer } from "./customer";
import { CustomerOrderItem } from "./customerOrderItem";
import { Shipping } from "./shippings";

@Injectable()
export class CustomerOrder {
	id!: number;
	customer!: Customer;
	nameOnCard!: string;
	cardNbr!: string;
	expirationDt!: string;
	cvv!: string;
	orderStatus!: string;
	customerOrderItems!: CustomerOrderItem[];
	shipping!: Shipping;
	shiptoAddress!: Address;
	constructor(@Inject(Number) id: number, @Inject(Customer) customer: Customer, @Inject(String) nameOnCard: string, @Inject(String) cardNbr: string, @Inject(String) expirationDt: string, @Inject(String) cvv: string, @Inject(String) orderStatus: string, @Inject(Array) customerOrderItems: CustomerOrderItem[], @Inject(Shipping) shipping: Shipping, @Inject(Address) shiptoAddress: Address) {
		this.id = id;
		this.customer = customer;
		this.nameOnCard = nameOnCard;
		this.cardNbr = cardNbr;
		this.expirationDt = expirationDt;
		this.cvv = cvv;
		this.orderStatus = orderStatus;
		this.customerOrderItems = customerOrderItems;
		this.shipping = shipping;
		this.shiptoAddress = shiptoAddress;
	}
}
