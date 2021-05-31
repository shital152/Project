package com.rsd.bo;

import javax.servlet.ServletContext;

public class UploadBo {
	private String role;
	private String uploadLoc;
	private Integer idval;
	private ServletContext sc;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUploadLoc() {
		return uploadLoc;
	}
	public void setUploadLoc(String uploadLoc) {
		this.uploadLoc = uploadLoc;
	}
	public Integer getIdval() {
		return idval;
	}
	public void setIdval(Integer idval) {
		this.idval = idval;
	}
	public ServletContext getSc() {
		return sc;
	}
	public void setSc(ServletContext sc) {
		this.sc = sc;
	}
	
}
