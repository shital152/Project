package com.rsd.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.bo.ProfileBo;
import com.rsd.dao.ProfileDao;
import com.rsd.dao.ProfileDaoImpl;

@WebServlet("/viewprofile")
public class ViewProfileController extends HttpServlet {
	private ProfileDao dao=null;
	private ProfileBo pbo=null;
	public void init(ServletConfig config) throws ServletException {
		dao=new ProfileDaoImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		int id=Integer.parseInt(req.getParameter("path"));
	try {
			if(id!=0) {
				pbo=dao.getProfile(id);
				pw.println("<center>");
				pw.println("<h1 style='color:blue'>Student Details</h1><br>");
				pw.println("<h3>Student  ID "+"\t: "+pbo.getId()+"</h3>");
				pw.println("<h3>Name          "+"\t: "+pbo.getName()+"</h3>");
				pw.println("<h3>Last Name  "+"\t: "+pbo.getLastName()+"</h3>");
				pw.println("<h3>Class			  "+"\t: "+pbo.getStd()+"</h3>");
				pw.println("</center>");
			}else {
				pw.println("<center><h1 style='color:red'>Internal Problem</h1></center>");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<center><h1 style='color:red'>Internal DB Problem</h1></center>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<center><h1 style='color:red'>Internal Problem</h1></center>");
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {
		
	}
}
