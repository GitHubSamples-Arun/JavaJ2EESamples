package com.jdbcWithSpring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class EmployeesDao extends JdbcDaoSupport
{
	public void addEmployee(int id,String fName,String lName,String email,Date hireDate,String jobId,long salary)
	{
		getJdbcTemplate().update("insert into employees(employee_id,first_name,last_name,email,hire_Date,job_id,salary) values(?,?,?,?,?,?,?)", id,fName,lName,email,hireDate,jobId,salary);
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = null;
		employees = getJdbcTemplate().query("select * from employees", 
				new RowMapper<Employee>() 
				{
					public Employee mapRow(ResultSet rs, int rowNum)throws SQLException 
					{
						Employee emp = new Employee();
						emp.setId(rs.getInt("employee_id"));
						emp.setFirstName(rs.getString("first_name"));
						emp.setLastName(rs.getString("last_name"));
						emp.setDesignation(rs.getString("email"));
						return emp;
					}
		});
		return employees;
	}
	public void deleteEmployee(int id)
	{
		getJdbcTemplate().update("delete from employees where employee_id=?", id);
	}
	/*public int getEmployeeCount()
	{
		return getJdbcTemplate().query("select count(*) from employees");
	}*/
}
