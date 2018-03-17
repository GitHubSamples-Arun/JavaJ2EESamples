package com.student.dao;

import java.util.List;
import java.util.Random;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.student.Student;
import com.student.StudentMapper;

public class StudentDAOImpl implements StudentDAO {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   public void create(String name, Integer age) {
	      String SQL = "insert into Student (id,name, age) values (?, ?, ?)";
	      
	      Random random = new Random();
	      Integer id = random.nextInt(900) + 100;
	      
	      Object[] inputs = new Object[] {id, name, age};
	      
	      jdbcTemplateObject.update( SQL, inputs);
	      System.out.println("Created Record Name = " + name + " Age = " + age +"Id =" +id);
	      return;
	   }
	   public Student getStudent(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      Student student = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new StudentMapper());
	      
	      return student;
	   }
	   public List<Student> listStudents() {
	      String SQL = "select * from Student";
	      List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
	      return students;
	   }
	   public void delete(Integer id) {
	      String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
	   public void update(Integer id, Integer age){
	      String SQL = "update Student set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, age, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	   }
	}
