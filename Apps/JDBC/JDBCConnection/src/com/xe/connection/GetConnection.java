package com.xe.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static void main(String [] args){
		getConnection();
	}

	public static Connection getConnection() {
		String driver="oracle.jdbc.driver.OracleDriver";
		String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName="hr";
		String dbPassword="hr";
		Connection con = null;

		try{
		Class.forName(driver);
		con=DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		System.out.println("Connection obtained"+con.toString());
		
		}catch(Exception e){
		e.printStackTrace();
		}
		return con;
	}

}
