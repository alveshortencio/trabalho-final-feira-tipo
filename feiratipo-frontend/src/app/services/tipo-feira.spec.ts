import { TestBed } from '@angular/core/testing';

import { TipoFeira } from './tipo-feira';

describe('TipoFeira', () => {
  let service: TipoFeira;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoFeira);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
