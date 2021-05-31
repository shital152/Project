package com.rsd.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}
			return con;	
	}
}
