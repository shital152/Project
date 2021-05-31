package com.rsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rsd.bo.AdminBo;
import com.rsd.commons.DBConnection;

public class AdminDaoImpl implements AdminDao {
	public static final String QUERY="SELECT COUNT(*) FROM ADMINLOGIN WHERE USERNAME=? AND PASSWORD=?";
	@Override
	public int adminInsert(AdminBo bo) throws Exception {
		Connection con=null;
		int count=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DBConnection.getConnection();
		if(con!=null) {
			ps=con.prepareStatement(QUERY);
			System.out.println(bo.getUser()+"  "+bo.getPwd());
			ps.setString(1, bo.getUser());
			ps.setString(2, bo.getPwd());
			rs=ps.executeQuery();
			while(rs.next()) {
					count=rs.getInt(1);
			}
		}
		return count;	
	}
}
