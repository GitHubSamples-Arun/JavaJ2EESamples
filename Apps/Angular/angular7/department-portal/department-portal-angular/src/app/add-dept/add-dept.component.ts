import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from "../core/api.service";

@Component({
  selector: 'app-add-dept',
  templateUrl: './add-dept.component.html',
  styleUrls: ['./add-dept.component.css']
})
export class AddDeptComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      departmentName: ['', Validators.required],
      locationId: ['', Validators.required],
      managerId: ['', Validators.required]
    });

  }

  onSubmit() {
    this.apiService.createDepartment(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-dept']);
      });
  }

}
