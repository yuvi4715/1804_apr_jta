import { TestBed, inject } from '@angular/core/testing';

import { DatabaseGetterService } from './database-getter.service';

describe('DatabaseGetterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DatabaseGetterService]
    });
  });

  it('should be created', inject([DatabaseGetterService], (service: DatabaseGetterService) => {
    expect(service).toBeTruthy();
  }));
});
