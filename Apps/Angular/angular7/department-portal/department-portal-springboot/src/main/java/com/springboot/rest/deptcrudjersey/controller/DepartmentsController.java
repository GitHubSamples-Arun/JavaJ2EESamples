package com.springboot.rest.deptcrudjersey.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.deptcrudjersey.bean.DepartmentRequest;
import com.springboot.rest.deptcrudjersey.model.ApiResponse;
import com.springboot.rest.deptcrudjersey.model.Departments;
import com.springboot.rest.deptcrudjersey.service.DepartmentsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/departments")
public class DepartmentsController {
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentsController.class);
	
	@Autowired 
	DepartmentsService departmentsService;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<List<Departments>> getAllDepartments(){
		
		log.info("getAllDepartments method, endpoint : /departments");
		List<Departments> deptList = departmentsService.getAllDepartments();
		log.info("Departments List" +deptList);
		
		return new ApiResponse<>(HttpStatus.OK.value(), "Department list fetched successfully.", deptList);
		
	}
	
	@RequestMapping(value="/{deptId}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Departments> findByDepartmentId(@PathVariable("deptId") Integer deptId) {
		
		log.info("findByDepartmentId method, endpoint : /departments/{deptId}");
		return new ApiResponse<>(HttpStatus.OK.value(), "Department fetched successfully.", departmentsService.findById(deptId));
		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Departments> saveDepartment(@RequestBody DepartmentRequest departmentRequest){
		
		log.info("saveDepartment method, endpoint : /departments/add");
		Departments dept = new Departments();
		dept.setDepartmentName(departmentRequest.getDepartmentName());
		dept.setLocationId(departmentRequest.getLocationId());
		dept.setManagerId(departmentRequest.getManagerId());
		
		Departments departments = departmentsService.saveDepartment(dept);
		log.info("Newly added Department" +departments);
		
		return new ApiResponse<>(HttpStatus.CREATED.value(), "Department created successfully.", departments);
		
	}
	
	@RequestMapping(value="/{deptId}",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Departments> updateDepartment(@RequestBody DepartmentRequest departmentRequest,
			@PathVariable("deptId") Integer deptId){
		
		log.info("updateDepartment method, endpoint : /departments/update/{deptId}");
		Departments dept = new Departments();
		dept.setDepartmentId(deptId);
		dept.setDepartmentName(departmentRequest.getDepartmentName());
		dept.setLocationId(departmentRequest.getLocationId());
		dept.setManagerId(departmentRequest.getManagerId());
			
		Departments departments = departmentsService.saveDepartment(dept);
		log.info("Updated Department" +departments);
		
		return new ApiResponse<>(HttpStatus.OK.value(), "Department updated successfully.", departments);
		
	}

	@RequestMapping(value="/{deptId}",method=RequestMethod.DELETE)
	public ApiResponse<Void> deleteDepartment(@PathVariable("deptId") Integer deptId){
		
		log.info("deleteDepartment method, endpoint : /rest/departments/delete/{deptId}");
		departmentsService.deleteByDepartmentId(deptId);	
		return new ApiResponse<>(HttpStatus.OK.value(), "Department deleted successfully.", null);
	}
	
}
