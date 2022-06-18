import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperiEditarComponent } from './experi-editar.component';

describe('ExperiEditarComponent', () => {
  let component: ExperiEditarComponent;
  let fixture: ComponentFixture<ExperiEditarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExperiEditarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperiEditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
