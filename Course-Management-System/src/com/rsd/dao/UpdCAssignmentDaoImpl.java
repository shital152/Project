package com.rsd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.rsd.bo.UploadBo;
import com.rsd.commons.DBConnection;

public class UpdCAssignmentDaoImpl implements UpdCAssignmentDao {
	public static final String SEM1="UPDATE CHECKASSIGNMENT SET FIRST_SEM=? WHERE ID=?";
	public static final String SEM2="UPDATE CHECKASSIGNMENT SET SECOUND_SEM=? WHERE ID=?";
	public static final String SEM3="UPDATE CHECKASSIGNMENT SET THIRD_SEM=? WHERE ID=?";
	public static final String SEM4="UPDATE CHECKASSIGNMENT SET FOURTH_SEM=? WHERE ID=?";
	public static final String SEM5="UPDATE CHECKASSIGNMENT SET FIFTH_SEM=? WHERE ID=?";
	
	@Override
	public int uploadAss(UploadBo ubo)throws Exception {
		ServletContext sc=ubo.getSc();
		String data=ubo.getRole();
		String fname=ubo.getUploadLoc();
		Integer idval=ubo.getIdval();
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement ps1=null,ps2=null,ps3=null,ps4=null,ps5=null;
		int result=0;
		if(data.equalsIgnoreCase("SEM_FIRST")&&con!=null) {
			ps1=con.prepareStatement(SEM1);
			ps1.setString(1,sc.getInitParameter("CHECK")+fname);
			ps1.setInt(2, idval);
			result=ps1.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SEM_SECOND")&&con!=null) {
			ps2=con.prepareStatement(SEM2);
			ps2.setString(1,sc.getInitParameter("CHECK")+fname);
			ps2.setInt(2, idval);
			result=ps2.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SEM_THIRD")&&con!=null) {
			ps3=con.prepareStatement(SEM3);
			ps3.setString(1,sc.getInitParameter("CHECK")+fname);
			ps3.setInt(2, idval);
			result=ps3.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SEM_FOURTH")&&con!=null) {
			ps4=con.prepareStatement(SEM4);
			ps4.setString(1,sc.getInitParameter("CHECK")+fname);
			ps4.setInt(2, idval);
			result=ps4.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SEM_FIFTH")&&con!=null) {
			ps5=con.prepareStatement(SEM5);
			ps5.setString(1,sc.getInitParameter("CHECK")+fname);
			ps5.setInt(2, idval);
			result=ps5.executeUpdate();
			
		}else {
			System.out.println("Invalid Statement");
		}
		return result;
	}
}
