package com.springboot.rest.deptcrudjersey.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentRequest {
	
	@JsonProperty("departmentId")
	private Integer departmentId;
	
	@JsonProperty("departmentName")
	private String departmentName;
	
	@JsonProperty("managerId")
	private Integer managerId;
	
	@JsonProperty("locationId")
	private Integer locationId;
	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

}
