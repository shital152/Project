package com.rsd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.bo.LoginBo;
import com.rsd.dao.FLoginDaoImpl;
import com.rsd.dao.LoginDao;
import com.rsd.dao.SLoginDaoImpl;


@WebServlet("/loginurl")
public class LoginController extends HttpServlet {
	private LoginDao dao=null,fdao=null;
	private LoginBo sbo=null,fbo=null;
	public void init(ServletConfig config) throws ServletException {
		dao=new SLoginDaoImpl();
		fdao=new FLoginDaoImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String user=null,pass=null,data=null;
		int result=0;
		user=req.getParameter("user");
		pass=req.getParameter("pass");
		data=req.getParameter("role");
		try {
			if(data.equalsIgnoreCase("student")) {
				sbo=new LoginBo();
				sbo.setUser(user);
				sbo.setPwd(pass);
				result=dao.insertLogin(sbo);
				if(result!=0) {
					ServletContext sct=req.getServletContext();
					sct.setAttribute("idval", result);
					//req.setAttribute("idval", result);
					RequestDispatcher rd=req.getRequestDispatcher("/ua.html");
					rd.forward(req, res);
				}else {
					pw.println("<br><center><h1 style='color:red'>Invalid Credentation</h1></center>");		
					RequestDispatcher rd=req.getRequestDispatcher("/login.html");
					rd.include(req, res);
				}
			}else {
				fbo=new LoginBo();
				fbo.setUser(user);
				fbo.setPwd(pass);
				result=fdao.insertLogin(fbo);
				if(result!=0) {
					ServletContext sct=req.getServletContext();
					sct.setAttribute("idval", result);
					RequestDispatcher rd=req.getRequestDispatcher("/uq.html");
					rd.forward(req, res);
				}else {
					pw.println("<br><center><h1 style='color:red'>Invalid Credentation</h1></center>");		
					RequestDispatcher rd=req.getRequestDispatcher("/login.html");
					rd.include(req, res);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.close();
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
