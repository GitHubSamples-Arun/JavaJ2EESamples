import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import { AddDeptComponent } from './add-dept/add-dept.component';
import { EditDeptComponent } from './edit-dept/edit-dept.component';
import { ListDeptComponent } from './list-dept/list-dept.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'add-dept', component: AddDeptComponent },
  { path: 'list-dept', component: ListDeptComponent },
  { path: 'edit-dept', component: EditDeptComponent },
  {path : '', component : LoginComponent}
];

export const routing = RouterModule.forRoot(routes);



