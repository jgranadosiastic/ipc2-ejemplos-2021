import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialDashboardComponent } from './historial-dashboard.component';

describe('HistorialDashboardComponent', () => {
  let component: HistorialDashboardComponent;
  let fixture: ComponentFixture<HistorialDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorialDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistorialDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
