import { Component, OnInit } from '@angular/core';
import { YenComponent } from '../yen/yen.component';

@Component({
  selector: 'app-usd',
  templateUrl: './usd.component.html',
  styleUrls: ['./usd.component.css']
})
export class UsdComponent implements OnInit {

  constructor() { }

  conversionRate:number = 107.46;
  _convertedValue:number = 0;

  _usdInput = 0;
  
  get usdInput(): number {
    return this._usdInput;
  }

  set usdInput(value: number) {
    this._usdInput = value;
    console.log("usd input enttered by user "+this.usdInput);
    this._convertedValue = this.usdInput  * this.conversionRate ;
    console.log("usd input converted to yen "+this.convertedValue);
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
