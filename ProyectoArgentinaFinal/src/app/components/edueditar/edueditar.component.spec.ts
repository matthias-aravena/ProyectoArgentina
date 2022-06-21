import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdueditarComponent } from './edueditar.component';

describe('EdueditarComponent', () => {
  let component: EdueditarComponent;
  let fixture: ComponentFixture<EdueditarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdueditarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EdueditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
