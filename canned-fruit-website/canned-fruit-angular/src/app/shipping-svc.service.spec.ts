import { TestBed } from '@angular/core/testing';

import { ShippingSvcService } from './shipping-svc.service';

describe('ShippingSvcService', () => {
  let service: ShippingSvcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShippingSvcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
