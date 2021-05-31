package com.rsd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rsd.bo.LoginBo;
import com.rsd.commons.DBConnection;

public class FLoginDaoImpl implements LoginDao {
	public static final String QUERY="SELECT COUNT(*) FROM FACULTYLOGIN WHERE USERNAME=? AND PASSWORD=?";
	public static final String INSERT="SELECT ID FROM FACULTYLOGIN WHERE USERNAME=? AND PASSWORD=?";
	@Override
	public int insertLogin(LoginBo bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		ResultSet rs=null,rs1=null;
		con=DBConnection.getConnection();
		int count=0,count1=0;
		if(con!=null) {
			ps=con.prepareStatement(QUERY);
			ps.setString(1,bo.getUser());
			ps.setString(2,bo.getPwd());
			rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
			}
		}
		if(count!=0) {
			ps1=con.prepareStatement(INSERT);
			ps1.setString(1,bo.getUser());
			ps1.setString(2,bo.getPwd());
			rs1=ps1.executeQuery();
			while(rs1.next()) {
				count1=rs1.getInt(1);
			}
		}
		return count1;
	}
}
