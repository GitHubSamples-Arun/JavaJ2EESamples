package com.springboot.rest.deptcrudjersey.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.deptcrudjersey.model.Departments;
import com.springboot.rest.deptcrudjersey.repository.DepartmentsCRUDRepository;
import com.springboot.rest.deptcrudjersey.service.DepartmentsService;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{
	
	@Autowired 
	private DepartmentsCRUDRepository departmentsCRUDRepository;
	
	public List<Departments> getAllDepartments(){
		return departmentsCRUDRepository.findAll();
	}
	
	public void deleteByDepartmentId(Integer departmentId) {
		Departments dept = new Departments();
		dept.setDepartmentId(departmentId);	
		departmentsCRUDRepository.delete(dept);
	}
	
	public Departments saveDepartment(Departments dept) {
		return departmentsCRUDRepository.save(dept);
	}

	public Optional<Departments> findByDepartmentId(Integer departmentId) {
		return departmentsCRUDRepository.findByDepartmentId(departmentId);
	}

}
