import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UsdComponent } from './usd/usd.component';
import { YenComponent } from './yen/yen.component';

@NgModule({
  declarations: [
    AppComponent,
    UsdComponent,
    YenComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
