import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaeditsobremiComponent } from './acercaeditsobremi.component';

describe('AcercaeditsobremiComponent', () => {
  let component: AcercaeditsobremiComponent;
  let fixture: ComponentFixture<AcercaeditsobremiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcercaeditsobremiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AcercaeditsobremiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
