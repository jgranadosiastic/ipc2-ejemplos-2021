import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialCardComponent } from './historial-card.component';

describe('HistorialCardComponent', () => {
  let component: HistorialCardComponent;
  let fixture: ComponentFixture<HistorialCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorialCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistorialCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
