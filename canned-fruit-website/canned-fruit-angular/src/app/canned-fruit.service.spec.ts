import { TestBed } from '@angular/core/testing';

import { CannedFruitService } from './canned-fruit.service';

describe('CannedFruitService', () => {
  let service: CannedFruitService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CannedFruitService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
