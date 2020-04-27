import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-yen',
  templateUrl: './yen.component.html',
  styleUrls: ['./yen.component.css']
})
export class YenComponent implements OnInit {
  conversionRate:number = 0.0093;
  _convertedValue:number = 0;

  constructor() { }

  _yenInput = 0;

  get yenInput(): number {
    return this._yenInput;
  }

  set yenInput(value: number) {
    this._yenInput = value;
    console.log("yen input enttered by user "+this.yenInput);
    this._convertedValue = this.yenInput  * this.conversionRate ;
    console.log("yen input converted to usd "+this.convertedValue);
  }

  get convertedValue():number {
    return this._convertedValue;
  }

  set convertedValue(convValue:number) {
     this.convertedValue = convValue;
  }

  ngOnInit() {
  }

}
