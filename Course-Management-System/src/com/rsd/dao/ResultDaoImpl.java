package com.rsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rsd.commons.DBConnection;

public class ResultDaoImpl implements ResultDao {
	public static final String SEM1="SELECT FIRST_SEM FROM CHECKASSIGNMENT";
	public static final String SEM2="SELECT SECOUND_SEM FROM CHECKASSIGNMENT";
	public static final String SEM3="SELECT THIRD_SEM FROM CHECKASSIGNMENT";
	public static final String SEM4="SELECT FOURTH_SEM FROM CHECKASSIGNMENT";
	public static final String SEM5="SELECT FIFTH_SEM FROM CHECKASSIGNMENT";
	
	@Override
	public String getFile(String data) throws Exception {
		Connection con=null;
		con=DBConnection.getConnection();
		ResultSet rs=null;
		PreparedStatement ps1=null,ps2=null,ps3=null,ps4=null,ps5=null;
		String result=null;
		if(data.equalsIgnoreCase("SEM_FIRST")&&con!=null) {
			ps1=con.prepareStatement(SEM1);
			rs=ps1.executeQuery();
			while(rs.next()) {
				result=rs.getString("FIRST_SEM");
			}
			
		}else if(data.equalsIgnoreCase("SEM_SECOND")&&con!=null) {
			ps2=con.prepareStatement(SEM2);
			rs=ps2.executeQuery();
			while(rs.next()) {
				result=rs.getString("SECOUND_SEM");
			}
			
		}else if(data.equalsIgnoreCase("SEM_THIRD")&&con!=null) {
			ps3=con.prepareStatement(SEM3);
			rs=ps3.executeQuery();
			while(rs.next()) {
				result=rs.getString("THIRD_SEM");
			}
			
		}else if(data.equalsIgnoreCase("SEM_FOURTH")&&con!=null) {
			ps4=con.prepareStatement(SEM4);
			rs=ps4.executeQuery();
			while(rs.next()) {
				result=rs.getString("FOURTH_SEM");
			}
			
		}else if(data.equalsIgnoreCase("SEM_FIFTH")&&con!=null) {
			ps5=con.prepareStatement(SEM5);
			rs=ps5.executeQuery();
			while(rs.next()) {
				result=rs.getString("FIFTH_SEM");
			}
			
		}else {
			System.out.println("Invalid Statement");
		}
		return result;
	}
}
