package com.rsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rsd.bo.ProfileBo;
import com.rsd.commons.DBConnection;

public class ProfileDaoImpl implements ProfileDao {
	public static final String GET_PROFILE="SELECT ID,NAME,LASTNAME,CLASS FROM STUDENTDETAILS WHERE ID=?";
	public ProfileBo bo=new ProfileBo();
	
	@Override
	public ProfileBo getProfile(int id) throws Exception {
		Connection con=null;
		con=DBConnection.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=null;
		if(con!=null) {
			ps=con.prepareStatement(GET_PROFILE);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					bo.setId(rs.getInt("ID"));
					bo.setName(rs.getString("NAME"));
					bo.setLastName(rs.getString("LASTNAME"));
					bo.setStd(rs.getString("CLASS"));
				}
			}	
		}
		return bo;
	}
}
