package com.springboot.rest.deptcrudjersey.service;

import java.util.List;
import java.util.Optional;

import com.springboot.rest.deptcrudjersey.model.Departments;

public interface DepartmentsService {
	
	List<Departments> getAllDepartments();
	
	Optional<Departments> findByDepartmentId(Integer departmentId);
	
	Departments saveDepartment(Departments dept);
	
	void deleteByDepartmentId(Integer departmentId);
	
}
