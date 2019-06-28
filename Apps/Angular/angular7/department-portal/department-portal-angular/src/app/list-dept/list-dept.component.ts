import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {Departments} from "../model/departments.model";
import {ApiService} from "../core/api.service";

@Component({
  selector: 'app-list-dept',
  templateUrl: './list-dept.component.html',
  styleUrls: ['./list-dept.component.css']
})
export class ListDeptComponent implements OnInit {

  departments: Departments[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    if(!window.localStorage.getItem('token')) {
      this.router.navigate(['login']);
      return;
    }
    this.apiService.getDepartments()
      .subscribe( data => {
          this.departments = data.result;
      });
  }

  deleteDept(departments: Departments): void {
    this.apiService.deleteDepartment(departments.departmentId)
      .subscribe( data => {
        this.departments = this.departments.filter(u => u !== departments);
      })
  };

  editDept(departments: Departments): void {
    window.localStorage.removeItem("editDeptId");
    window.localStorage.setItem("editDeptId", departments.departmentId.toString());
    this.router.navigate(['edit-dept']);
  };

  addDept(): void {
    this.router.navigate(['add-dept']);
  };
}
