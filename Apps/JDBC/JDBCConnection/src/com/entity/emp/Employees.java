package com.entity.emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xe.connection.GetConnection;

public class Employees {
	//static GetConnection gc = new GetConnection();
	static Connection con = GetConnection.getConnection();
	
	public static void main(String args[]){
		Statement stmt;
		try {
			stmt = con.createStatement();
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from employees");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  			  
			//step5 close the connection object  
			con.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  

		  
	}
}
