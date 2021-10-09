import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialTableComponent } from './historial-table.component';

describe('HistorialTableComponent', () => {
  let component: HistorialTableComponent;
  let fixture: ComponentFixture<HistorialTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorialTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistorialTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
