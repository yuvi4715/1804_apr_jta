import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiptGenerateComponent } from './receipt-generate.component';

describe('ReceiptGenerateComponent', () => {
  let component: ReceiptGenerateComponent;
  let fixture: ComponentFixture<ReceiptGenerateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceiptGenerateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiptGenerateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
