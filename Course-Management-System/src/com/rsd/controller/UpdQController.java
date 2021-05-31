package com.rsd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.bo.UploadBo;
import com.rsd.dao.FuploadDao;
import com.rsd.dao.FuploadDaoImpl;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

@WebServlet("/questioncontroller")
public class UpdQController extends HttpServlet {
	private FuploadDao fdao=null;
	private UploadBo ubo=null;
	public void init(ServletConfig config) throws ServletException {
		fdao=new FuploadDaoImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String data=null,fname=null;
		int result=0;
		MultipartFormDataRequest mreq=null;
		UploadBean updb=null;
		Hashtable map=null;
		ServletContext sct=req.getServletContext();
		Integer idval=(Integer)sct.getAttribute("idval");
	try {
			mreq=new MultipartFormDataRequest(req);
			data=mreq.getParameter("sub");
			updb=new UploadBean();
			updb.setFolderstore("c:/facultyquestions");
			updb.setOverwrite(false);
			updb.store(mreq,"file");
			map=mreq.getFiles();
			fname=((UploadFile)map.get("file")).getFileName();
			ubo=new UploadBo();
			ubo.setIdval(idval);
			ubo.setUploadLoc(fname);
			ubo.setRole(data);
			ubo.setSc(sct);
			result=fdao.uploadFile(ubo);
			if(result!=0) {
				pw.println("<br><br><h1 style='color:green;align:center'> Upload Successfully</h1>");
			}else {
				pw.println("<br><br><h1 style='color:red;align:center'> Upload Fail</h1>");
			}
		}catch(UploadException ue) {
			ue.printStackTrace();
			pw.println("<br><br><h1 style='color:red;align:center'> Upload Fail</h1>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {		
	}
}
