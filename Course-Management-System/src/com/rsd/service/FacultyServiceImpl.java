package com.rsd.service;

import java.util.function.Supplier;
import com.rsd.bo.FacultyBo;
import com.rsd.commons.SendMail;
import com.rsd.dao.FacultyDao;
import com.rsd.dao.FacultyDaoImpl;
import com.rsd.dto.FacultyDto;

public class FacultyServiceImpl implements FacultyService {
	private FacultyDao dao=null;
	private FacultyBo bo=null;
	private int result=0;
	private static String id=null;
	
	public FacultyServiceImpl() {
		dao=new FacultyDaoImpl();
	}
	public static String idGenerate() {
		Supplier<String> s=()->{
			String idcreate="";
			for (int i=1;i<=3 ;i++ )
			{
			        idcreate=idcreate+(int)(Math.random()*10);
			}
			return idcreate;
		};
		StringBuilder sid=new StringBuilder("11");
		sid=sid.append(s.get());
		id=sid.toString();
		return id;
	}
	@Override
	public int facultyService(FacultyDto dto) throws Exception {
		bo=new FacultyBo();
		String id=FacultyServiceImpl.idGenerate();
		bo.setId(id);bo.setName(dto.getName());bo.setLastName(dto.getLastName());bo.setUser(dto.getUser());bo.setPhon(dto.getPhon());bo.setGenger(dto.getGenger());bo.setRole(dto.getRole());bo.setPass(dto.getPass());bo.setClassStd(dto.getClassStd());
		result=dao.facultyInsert(bo);
		if(result!=0) {
			String msg= dto.getName()+" Your Account Has been Created and your UserName :"+dto.getUser()+"and password : "+dto.getPass();
			SendMail.setMail(dto.getUser(), "Account Created", msg);
			return result;
		}else {
			return result;
		}		
	}
}
