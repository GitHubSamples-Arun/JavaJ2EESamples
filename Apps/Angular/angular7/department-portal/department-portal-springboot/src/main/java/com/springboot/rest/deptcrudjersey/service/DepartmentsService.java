package com.springboot.rest.deptcrudjersey.service;

import java.util.List;

import com.springboot.rest.deptcrudjersey.model.Departments;

public interface DepartmentsService {
	
	List<Departments> getAllDepartments();
		
	Departments saveDepartment(Departments dept);
	
	void deleteByDepartmentId(Integer departmentId);
	
	Departments findById(Integer id);

}
