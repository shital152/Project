package com.rsd.service;

import com.rsd.bo.AdminBo;
import com.rsd.dao.AdminDao;
import com.rsd.dao.AdminDaoImpl;
import com.rsd.dto.AdminDto;

public class AdminServiceImpl implements AdminService {
		private AdminDao dao=null;
		private AdminBo bo=null;
		private int result=0;
		
		public AdminServiceImpl() {
			dao=new AdminDaoImpl();
		}
	@Override
	public int adminService(AdminDto dto) throws Exception {
		bo=new AdminBo();
		bo.setUser(dto.getUser());
		bo.setPwd(dto.getPwd());
		result=dao.adminInsert(bo);
		return result;
	}
}
