import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaeditComponent } from './acercaedit.component';

describe('AcercaeditComponent', () => {
  let component: AcercaeditComponent;
  let fixture: ComponentFixture<AcercaeditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcercaeditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AcercaeditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
