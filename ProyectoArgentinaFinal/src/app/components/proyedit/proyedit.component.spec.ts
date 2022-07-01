import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyeditComponent } from './proyedit.component';

describe('ProyeditComponent', () => {
  let component: ProyeditComponent;
  let fixture: ComponentFixture<ProyeditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProyeditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProyeditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
