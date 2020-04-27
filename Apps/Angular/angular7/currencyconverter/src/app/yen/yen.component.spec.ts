import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YenComponent } from './yen.component';

describe('YenComponent', () => {
  let component: YenComponent;
  let fixture: ComponentFixture<YenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
