import { TestBed } from '@angular/core/testing';
import { CustomerOrderService } from './customerOrder-svc.service';

import { CustomerService } from './customer-svc.service';

describe('CustomerService', () => {
  let service: CustomerOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
