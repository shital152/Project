package com.rsd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rsd.bo.StudentBo;
import com.rsd.commons.DBConnection;

public class StudentDaoImpl implements StudentDao {
	public static final String INSERT="INSERT INTO STUDENTDETAILS VALUES(?,?,?,?,?,?,?,?)";
	public static final String LOGIN="INSERT INTO STUDENTLOGIN VALUES(?,?,?)";
	public static final String SEM1="INSERT INTO FIRST_SEM(ID)VALUES(?)";
	public static final String SEM2="INSERT INTO SECOUND_SEM(ID)VALUES(?)";
	public static final String SEM3="INSERT INTO THIRD_SEM(ID)VALUES(?)";
	public static final String SEM4="INSERT INTO FOURTH_SEM(ID)VALUES(?)";
	public static final String SEM5="INSERT INTO FIFTH_SEM(ID)VALUES(?)";
	
	@Override
	public int stdInsert(StudentBo bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null,ps1=null,psSem1=null,psSem2=null,psSem3=null,psSem4=null,psSem5=null;
		int count=0,count1=0;
		con=DBConnection.getConnection();
		if(con!=null) {
			ps=con.prepareStatement(INSERT);
			ps.setString(1,bo.getId());
			ps.setString(2,bo.getName());
			ps.setString(3,bo.getLastName());
			ps.setString(4,bo.getUser());
			ps.setString(5,bo.getPhon());
			ps.setString(6,bo.getGenger());
			ps.setString(7,bo.getClassStd());
			ps.setString(8,bo.getPass());
			count=ps.executeUpdate();
		}
		if(con!=null) {
			ps1=con.prepareStatement(LOGIN);
			ps1.setString(1,bo.getId());
			ps1.setString(2,bo.getUser());
			ps1.setString(3,bo.getPass());
			count1=ps1.executeUpdate();
		}if(con!=null&&count1!=0) {
			psSem1=con.prepareStatement(SEM1);
			psSem1.setString(1,bo.getId());
			count1=psSem1.executeUpdate();
		}
		if(con!=null&&count1!=0) {
			psSem2=con.prepareStatement(SEM2);
			psSem2.setString(1,bo.getId());
			count1=psSem2.executeUpdate();
		}
		if(con!=null&&count1!=0) {
			psSem3=con.prepareStatement(SEM3);
			psSem3.setString(1,bo.getId());
			count1=psSem3.executeUpdate();
		}
		if(con!=null&&count1!=0) {
			psSem4=con.prepareStatement(SEM4);
			psSem4.setString(1,bo.getId());
			count1=psSem4.executeUpdate();
		}
		if(con!=null&&count1!=0) {
			psSem5=con.prepareStatement(SEM5);
			psSem5.setString(1,bo.getId());
			count1=psSem5.executeUpdate();
		}
		return count;
	}
}
