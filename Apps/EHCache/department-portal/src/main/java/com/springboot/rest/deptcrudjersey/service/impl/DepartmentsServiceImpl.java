package com.springboot.rest.deptcrudjersey.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.deptcrudjersey.model.Departments;
import com.springboot.rest.deptcrudjersey.repository.DepartmentsCRUDRepository;
import com.springboot.rest.deptcrudjersey.service.DepartmentsService;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{
	private static final Logger log = LoggerFactory.getLogger(DepartmentsServiceImpl.class);
	
	@Autowired 
	private DepartmentsCRUDRepository departmentsCRUDRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	//@Cacheable(value="deptCache")
	public List<Departments> getAllDepartments(){
		return departmentsCRUDRepository.findAll();
	}
	
	// @CacheEvict annotation removes one or all entries from cached storage.
    // <code>allEntries=true</code> attribute allows developers to purge all entries from the cache.
    @CacheEvict(value="deptCache", key="#p0")
    @Transactional
	public void deleteByDepartmentId(Integer departmentId) {
		Departments dept = new Departments();
		dept.setDepartmentId(departmentId);	
		departmentsCRUDRepository.delete(dept);
	}
	
    @Transactional
	public Departments saveDepartment(Departments dept) {
		return departmentsCRUDRepository.save(dept);
	}
	
    // @Cacheable annotation adds the caching behaviour. 
    // If multiple requests are received, then the method won't be repeatedly executed, instead, the results are shared from cached storage.
    @Cacheable(value="deptCache", key="#p0")
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Departments findById(Integer id) {
		Optional<Departments> optionalDept = departmentsCRUDRepository.findById(id);
		log.info("Fetching department details from database for department: "+id);
		return optionalDept.isPresent() ? optionalDept.get() : null;
	}
    
    // @CachePut annotation updates the cached value.
    // @CachePut(value="deptCache")
    // @CacheEvict(allEntries = true) 
    // @CacheEvict(value = "deptCache", key = "#p0")
    @CacheEvict(value = "deptCache",allEntries = true) 
	@Transactional
    public Departments updateDepartment(Departments dept) {
		return departmentsCRUDRepository.save(dept);
	}

}
