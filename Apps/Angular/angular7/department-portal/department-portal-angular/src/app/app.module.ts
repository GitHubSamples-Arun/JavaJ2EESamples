import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AddDeptComponent } from './add-dept/add-dept.component';
import { EditDeptComponent } from './edit-dept/edit-dept.component';
import { ListDeptComponent } from './list-dept/list-dept.component';
import {ApiService} from "./core/api.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {routing} from "./app.routing";
import {TokenInterceptor} from "./core/interceptor";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddDeptComponent,
    EditDeptComponent,
    ListDeptComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ApiService, {provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }



