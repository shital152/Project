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

import com.rsd.dto.AdminDto;
import com.rsd.service.AdminService;
import com.rsd.service.AdminServiceImpl;
import com.rsd.vo.AdminVo;

@WebServlet("/adminurl")
public class AdminController extends HttpServlet {
	private AdminService service=null;
	
	public void init(ServletConfig config) throws ServletException {
		service=new AdminServiceImpl();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		AdminVo vo=null;
		AdminDto dto=null;
		String data=null;
		int count=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		vo=new AdminVo();
		vo.setUser(req.getParameter("user"));
		vo.setPwd(req.getParameter("pass"));
		dto=new AdminDto();
		dto.setUser(vo.getUser());
		dto.setPwd(vo.getPwd());
		try {
			count=service.adminService(dto);
				if(count==0) {
					pw.println("<br><br> <center><h1 style='color:red'>Invalid Credentation</h1></center>");
					RequestDispatcher rd=req.getRequestDispatcher("/adminLogin.html");
					rd.include(req, res);						
				}else {
					RequestDispatcher rd=req.getRequestDispatcher("/register.html");
					rd.forward(req, res);		
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
