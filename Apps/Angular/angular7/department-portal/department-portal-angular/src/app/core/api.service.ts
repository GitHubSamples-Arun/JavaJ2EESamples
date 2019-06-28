import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../model/user.model";
import {Departments} from "../model/departments.model";
import {Observable} from "rxjs/index";
import {ApiResponse} from "../model/api.response";

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/departments/';

  login(loginPayload) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload);
  }

  getDepartments() : Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl);
  }

  getDepartmentById(departmentId: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl + departmentId);
  }

  createDepartment(departments: Departments): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, departments);
  }

  updateDepartment(departments: Departments): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + departments.departmentId, departments);
  }

  deleteDepartment(departmentId: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + departmentId);
  }
}
