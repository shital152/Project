package com.rsd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.dto.FacultyDto;
import com.rsd.dto.StudentDto;
import com.rsd.service.FacultyService;
import com.rsd.service.FacultyServiceImpl;
import com.rsd.service.StudentService;
import com.rsd.service.StudentServiceImpl;
import com.rsd.vo.FacultyVo;
import com.rsd.vo.StudentVo;

@WebServlet("/reg")
public class ResgistrationController extends HttpServlet {
	private FacultyService service=null;
	private StudentService stuService=null;
	private FacultyVo vo=null;
	private StudentVo fvo=null;
	private FacultyDto dto=null;
	private StudentDto stdDto=null;
  	public void init(ServletConfig config) throws ServletException {
		service=new FacultyServiceImpl();	
		stuService=new StudentServiceImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String data=null;
		int result=0,result1=0;
		data=req.getParameter("rol");	
		try {
			if(data.equalsIgnoreCase("F")) {
				vo=new FacultyVo();
				vo.setName(req.getParameter("name"));
				vo.setLastName(req.getParameter("last"));
				vo.setUser(req.getParameter("user"));
				vo.setPhon(req.getParameter("phon"));
				vo.setGenger(req.getParameter("gen"));
				vo.setRole(req.getParameter("rol"));
				vo.setPass(req.getParameter("pass"));
				vo.setConfirmPass(req.getParameter("cpass"));
				vo.setClassStd(req.getParameter("department"));
					dto=new FacultyDto();
					dto.setName(vo.getName());dto.setLastName(vo.getLastName());dto.setUser(vo.getUser());dto.setPhon(vo.getPhon());dto.setGenger(vo.getGenger());dto.setRole(vo.getRole());dto.setPass(vo.getPass());dto.setClassStd(vo.getClassStd());
				result=service.facultyService(dto);
				if(result!=0) {
					RequestDispatcher rd=req.getRequestDispatcher("/stuprofile.html");
					rd.forward(req, res);
				}else {
					pw.println("<center><h1 style='color:red'>Registration Fail</h1></center>");
					RequestDispatcher rd=req.getRequestDispatcher("/register.html");
					rd.include(req, res);
				}
		}else {
			fvo=new StudentVo();
			fvo.setUser(req.getParameter("user"));
			fvo.setName(req.getParameter("name"));
			fvo.setLastName(req.getParameter("last"));
			fvo.setPhon(req.getParameter("phon"));
			fvo.setGenger(req.getParameter("gen"));
			fvo.setRole(req.getParameter("rol"));
			fvo.setPass(req.getParameter("pass"));
			fvo.setConfirmPass(req.getParameter("cpass"));
			fvo.setClassStd(req.getParameter("department"));
			    stdDto=new StudentDto();
				stdDto.setName(fvo.getName());stdDto.setLastName(fvo.getLastName());stdDto.setUser(fvo.getUser());stdDto.setPhon(fvo.getPhon());stdDto.setGenger(fvo.getGenger());stdDto.setRole(fvo.getRole());stdDto.setPass(fvo.getPass());stdDto.setClassStd(fvo.getClassStd());
			result1=stuService.stdService(stdDto);
			if(result1!=0) {
				RequestDispatcher rd=req.getRequestDispatcher("/stuprofile.html");
				rd.forward(req, res);
			}else {
				pw.println("<center><h1 style='color:red'>Registration Fail</h1></center>");
				RequestDispatcher rd=req.getRequestDispatcher("/register.html");
				rd.include(req, res);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	public void destroy() {
	}
}
