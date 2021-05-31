package com.rsd.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.dao.FdownloadDaoImpl;
import com.rsd.dao.ResultDao;
import com.rsd.dao.ResultDaoImpl;

@WebServlet("/checkresult")
public class ResultController extends HttpServlet {
	private ResultDao dao=null;
	public void init(ServletConfig config) throws ServletException {
		dao=new ResultDaoImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		String data=null,result=null;
		FileInputStream fis=null;
		int byteRead=0;
	try {
			data=req.getParameter("sub");
			result=dao.getFile(data);
			if(result!=null) {
				res.setContentType("APPLICATION/OCTET-STREAM");
				res.setHeader("content-disposition","attachment;fileName=\""+result+"\"");
				fis=new FileInputStream(result);
				while((byteRead=fis.read())!=-1) {
					pw.write(byteRead);
				}//while
			}else {
				res.setContentType("text/html");
				pw.println("<center><h1 style='color:red'>Result Not Display</h1></center>");
			}
		}catch(SQLException se) {
			pw.println("<center><h1 style='color:red'>Internal DB Problem</h1></center>");
		}catch(NullPointerException e) {
			pw.println("<center><h1 style='color:red'>Result Not Display</h1></center>");
		}catch(Exception e) {
			pw.println("<center><h1 style='color:red'>Result Not Display</h1></center>");
		}
		if(fis!=null&&pw!=null) {
		  fis.close();
		  pw.close();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {
		
	}
}
