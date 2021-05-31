package com.rsd.commons;

public class SendMail {
	public static void setMail(String mail,String sub,String msg) {
		//from,password,to,subject,message  
	     Mail.send("Mail","Password",mail,sub,msg);  
	}   
}
