import { TestBed } from '@angular/core/testing';

import { Feira } from './feira';

describe('Feira', () => {
  let service: Feira;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Feira);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
