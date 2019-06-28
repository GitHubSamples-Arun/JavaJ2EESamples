import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {Departments} from "../model/departments.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {ApiService} from "../core/api.service";

@Component({
  selector: 'app-edit-dept',
  templateUrl: './edit-dept.component.html',
  styleUrls: ['./edit-dept.component.css']
})
export class EditDeptComponent implements OnInit {

  dept: Departments;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    let deptId = window.localStorage.getItem("editDeptId");
    if(!deptId) {
      alert("Invalid action.")
      this.router.navigate(['list-dept']);
      return;
    }
    this.editForm = this.formBuilder.group({
	  departmentId: [''],
      departmentName: ['', Validators.required],
      locationId: ['', Validators.required],
      managerId: ['', Validators.required]
    });
    this.apiService.getDepartmentById(+deptId)
      .subscribe( data => {
        this.editForm.setValue(data.result);
      });
  }

  onSubmit() {
    this.apiService.updateDepartment(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          if(data.status === 200) {
            alert('Dept updated successfully.');
            this.router.navigate(['list-dept']);
          }else {
            alert(data.message);
          }
        },
        error => {
          alert(error);
        });
  }
  
}

