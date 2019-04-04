import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrinkDashboardComponent } from './drink-dashboard.component';

describe('DrinkDashboardComponent', () => {
  let component: DrinkDashboardComponent;
  let fixture: ComponentFixture<DrinkDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrinkDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrinkDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
