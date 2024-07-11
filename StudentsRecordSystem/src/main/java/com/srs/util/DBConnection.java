package com.srs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String Url = "jdbc:mysql://localhost:3306/student_db";
	private static final String User = "root";
	private static final String pswd = "Pavan@2507";

	public static  Connection getConnection()
	{
		Connection con=null;
		
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(Url, User, pswd);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return con;
	}

}
