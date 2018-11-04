package com.springboot.rest.deptcrudjersey.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.deptcrudjersey.model.Departments;

@Repository
public interface DepartmentsCRUDRepository extends CrudRepository<Departments, Integer> {
	
	List<Departments> findAll(); 
	
	Optional<Departments> findByDepartmentId(Integer departmentId);
	
	void delete(Departments dept);
	
	Departments save(Departments dept);
	
	boolean existsById(Integer id);

}
