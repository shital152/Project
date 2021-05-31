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
import com.rsd.dao.FdownloadDao;
import com.rsd.dao.FdownloadDaoImpl;

@WebServlet("/reporturl")
public class GetFileController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		String data=null;
		FileInputStream fis=null;
		int byteRead=0;
	try {
			data=req.getParameter("path");
			if(data!=null) {
				res.setContentType("APPLICATION/OCTET-STREAM");
				res.setHeader("content-disposition","attachment;fileName=\""+data+"\"");
				fis=new FileInputStream(data);
				while((byteRead=fis.read())!=-1) {
					pw.write(byteRead);
				}//while
			}else {
				res.setContentType("text/html");
				pw.println("<center><h1 style='color:red'>File not available</h1></center>");
			}
		}catch(NullPointerException e) {
			pw.println("<center><h1 style='color:red'>File not available</h1></center>");
		}catch(Exception e) {
			pw.println("<center><h1 style='color:red'>File not available</h1></center>");
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
