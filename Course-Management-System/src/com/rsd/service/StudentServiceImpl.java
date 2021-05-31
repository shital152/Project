package com.rsd.service;

import java.util.function.Supplier;

import com.rsd.bo.FacultyBo;
import com.rsd.bo.StudentBo;
import com.rsd.commons.SendMail;
import com.rsd.dao.StudentDao;
import com.rsd.dao.StudentDaoImpl;
import com.rsd.dto.StudentDto;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao=null;
	private StudentBo bo=null;
	private int result=0;
	private static String id=null;
	
	public StudentServiceImpl() {
		dao=new StudentDaoImpl();
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
	public int stdService(StudentDto dto) throws Exception {
		bo=new StudentBo();
		String id=StudentServiceImpl.idGenerate();
		bo.setId(id);bo.setName(dto.getName());bo.setLastName(dto.getLastName());bo.setUser(dto.getUser());bo.setPhon(dto.getPhon());bo.setGenger(dto.getGenger());bo.setRole(dto.getRole());bo.setPass(dto.getPass());bo.setClassStd(dto.getClassStd());
		result=dao.stdInsert(bo);
		if(result!=0) {
			String msg="Name : "+ dto.getName()+" Your Account Has been Created and your UserName :"+dto.getUser()+" and password : "+dto.getPass();
			SendMail.setMail(dto.getUser(), "Account Created", msg);
			return result;
		}else {
			return result;
		}		
	}
}
