package com.springboot.rest.deptcrudjersey.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.deptcrudjersey.bean.DepartmentRequest;
import com.springboot.rest.deptcrudjersey.model.Departments;
import com.springboot.rest.deptcrudjersey.service.DepartmentsService;

@RestController
public class DepartmentsController {
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentsController.class);
	
	@Autowired 
	DepartmentsService departmentsService;
	
	@RequestMapping(value="/rest/departments",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Departments>> getAllDepartments(){
		
		log.info("getAllDepartments method, endpoint : /rest/departments");
		List<Departments> deptList = departmentsService.getAllDepartments();
		log.info("Departments List" +deptList);
		
		return ResponseEntity.ok().body(deptList);
		
	}
	
	@RequestMapping(value="/rest/departments/{deptId}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Departments> findByDepartmentId(@PathVariable("deptId") Integer deptId) {
		
		log.info("findByDepartmentId method, endpoint : /rest/departments/{deptId}");
		return departmentsService.findByDepartmentId(deptId);
		
	}
	
	@RequestMapping(value="/rest/departments/add",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departments> saveDepartment(@RequestBody DepartmentRequest departmentRequest){
		
		log.info("saveDepartment method, endpoint : /rest/departments/add");
		Departments dept = new Departments();
		dept.setDepartmentName(departmentRequest.getDepartmentName());
		dept.setLocationId(departmentRequest.getLocationId());
		dept.setManagerId(departmentRequest.getManagerId());
		
		Departments departments = departmentsService.saveDepartment(dept);
		log.info("Newly added Department" +departments);
		
		return ResponseEntity.status(201).body(departments);
		
	}
	
	@RequestMapping(value="/rest/departments/update/{deptId}",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departments> updateDepartment(@RequestBody DepartmentRequest departmentRequest,
			@PathVariable("deptId") Integer deptId){
		
		log.info("updateDepartment method, endpoint : /rest/departments/update/{deptId}");
		Departments dept = new Departments();
		dept.setDepartmentId(deptId);
		dept.setDepartmentName(departmentRequest.getDepartmentName());
		dept.setLocationId(departmentRequest.getLocationId());
		dept.setManagerId(departmentRequest.getManagerId());
			
		Departments departments = departmentsService.saveDepartment(dept);
		log.info("Updated Department" +departments);
		
		return ResponseEntity.ok().body(departments);
		
	}

	@RequestMapping(value="/rest/departments/delete/{deptId}",method=RequestMethod.DELETE)
	public void deleteDepartment(@PathVariable("deptId") Integer deptId){
		
		log.info("deleteDepartment method, endpoint : /rest/departments/delete/{deptId}");
		departmentsService.deleteByDepartmentId(deptId);	
		
	}
	
}
