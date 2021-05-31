package com.rsd.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.commons.DBConnection;

@WebServlet("/getassignment")
public class GetAllAssignmentController extends HttpServlet {
	public static final String SEM1_CO="SELECT ID,CO FROM FIRST_SEM";
	public static final String SEM1_CPP="SELECT ID,CPP FROM FIRST_SEM";
	public static final String SEM1_COSM="SELECT ID,COSM FROM FIRST_SEM";
	public static final String SEM1_PM="SELECT ID,PM FROM FIRST_SEM";
	public static final String SEM1_CK="SELECT ID,CK FROM FIRST_SEM";
	
	public static final String SEM2_DS="SELECT ID,DS FROM SECOUND_SEM";
	public static final String SEM2_OOP="SELECT ID,OOP FROM SECOUND_SEM";
	public static final String SEM2_SAD="SELECT ID,SAD FROM SECOUND_SEM";
	public static final String SEM2_DC="SELECT ID,DC FROM SECOUND_SEM";
	public static final String SEM2_BS="SELECT ID,BS FROM SECOUND_SEM";
	
	public static final String SEM3_OS="SELECT ID,OS FROM THIRD_SEM";
	public static final String SEM3_FSDP="SELECT ID,FSDP FROM THIRD_SEM";
	public static final String SEM3_JAVA="SELECT ID,JAVA FROM THIRD_SEM";
	public static final String SEM3_CN="SELECT ID,CN FROM THIRD_SEM";
	public static final String SEM3_COOT="SELECT ID,COOT FROM THIRD_SEM";
	
	public static final String SEM4_DBMS="SELECT ID,DBMS FROM FOURTH_SEM";
	public static final String SEM4_CSC="SELECT ID,CSC FROM FOURTH_SEM";
	public static final String SEM4_MT="SELECT ID,MT FROM FOURTH_SEM";
	public static final String SEM4_EC="SELECT ID,EC FROM FOURTH_SEM";
	public static final String SEM4_ELECTIVE_I="SELECT ID,ELECTIVE FROM FOURTH_SEM";
	
	public static final String SEM5_AI="SELECT ID,AI FROM FIFTH_SEM";
	public static final String SEM5_SPM="SELECT ID,SPM FROM FIFTH_SEM";
	public static final String SEM5_SAS="SELECT ID,SAS FROM FIFTH_SEM";
	public static final String SEM5_MIS="SELECT ID,MIS FROM FIFTH_SEM";
	public static final String SEM5_ELECTIVE_II="SELECT ID,ELECTIVE FROM FIFTH_SEM";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		String data=null;
		Connection con=DBConnection.getConnection();
		PreparedStatement psCo=null,psCpp=null,psCosm=null,psPm=null,psCk=null,psDs=null,psOop=null,psSad=null,psDc=null,psBs=null;
		PreparedStatement psOs=null,psFsdp=null,psJava=null,psCn=null,psCoot=null,psDbms=null,psCsc=null,psMt=null,psEc=null,psElective_I=null;
		PreparedStatement psAi=null,psSpm=null,psSas=null,psMis=null,psElective_II=null;
		ResultSet rs=null;
	try {
			data=req.getParameter("sub");
			pw.println("<center><h1 style='color:blue'>All Student Assignment Record</h1></center><br>");
			pw.println("<center><table border='1' bgcolor='white'>");
			if(data.equalsIgnoreCase("CO")&&con!=null) {
				psCo=con.prepareStatement(SEM1_CO);
				rs=psCo.executeQuery();
				pw.println("<tr><th>STD ID</th><th>CO</th></tr> ");
    	    	while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("CO")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("CO")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	    
			}else if(data.equalsIgnoreCase("CPP")&&con!=null) {
				psCpp=con.prepareStatement(SEM1_CPP);
				rs=psCpp.executeQuery();
				pw.println("<tr><th>STD ID</th><th>CPP</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("CPP")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("CPP")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	    
			}else if(data.equalsIgnoreCase("COSM")&&con!=null) {
				psCosm=con.prepareStatement(SEM1_COSM);
				rs=psCosm.executeQuery();
				pw.println("<tr><th>STD ID</th><th>COSM</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("COSM")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("COSM")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	    
			}else if(data.equalsIgnoreCase("PM")&&con!=null) {
				psPm=con.prepareStatement(SEM1_PM);
				rs=psPm.executeQuery();
				pw.println("<tr><th>STD ID</th><th>PM</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("PM")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("PM")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	    
			}else if(data.equalsIgnoreCase("CK")&&con!=null) {
				psCk=con.prepareStatement(SEM1_CK);
				rs=psCk.executeQuery();
				pw.println("<tr><th>STD ID</th><th>CK</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("CK")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("CK")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	    
			}else if(data.equalsIgnoreCase("DS")&&con!=null) {
				psDs=con.prepareStatement(SEM2_DS);
				rs=psDs.executeQuery();
				pw.println("<tr><th>STD ID</th><th>DS</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("DS")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("DS")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("OOP")&&con!=null) {
				psOop=con.prepareStatement(SEM2_OOP);
				rs=psOop.executeQuery();
				pw.println("<tr><th>STD ID</th><th>OOP</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("OOP")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("OOP")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("SAD")&&con!=null) {
				psSad=con.prepareStatement(SEM2_SAD);
				rs=psSad.executeQuery();
				pw.println("<tr><th>STD ID</th><th>SAD</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("SAD")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("SAD")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("DC")&&con!=null) {
				psDc=con.prepareStatement(SEM2_DC);
				rs=psDc.executeQuery();
				pw.println("<tr><th>STD ID</th><th>DC</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("DC")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("DC")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("BS")&&con!=null) {
				psBs=con.prepareStatement(SEM2_BS);
				rs=psBs.executeQuery();
				pw.println("<tr><th>STD ID</th><th>BS</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("BS")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("BS")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("OS")&&con!=null) {
				psOs=con.prepareStatement(SEM3_OS);
				rs=psOs.executeQuery();
				pw.println("<tr><th>STD ID</th><th>OS</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("OS")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("OS")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("FSDP")&&con!=null) {
				psFsdp=con.prepareStatement(SEM3_FSDP);
				rs=psFsdp.executeQuery();
				pw.println("<tr><th>STD ID</th><th>FSDP</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("FSDP")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("FSDP")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("JAVA")&&con!=null) {
				psJava=con.prepareStatement(SEM3_JAVA);
				rs=psJava.executeQuery();
				pw.println("<tr><th>STD ID</th><th>JAVA</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("JAVA")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("JAVA")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("CN")&&con!=null) {
				psCn=con.prepareStatement(SEM3_CN);
				rs=psCn.executeQuery();
				pw.println("<tr><th>STD ID</th><th>CN</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("CN")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("CN")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("COOT")&&con!=null) {
				psCoot=con.prepareStatement(SEM3_COOT);
				rs=psCoot.executeQuery();
				pw.println("<tr><th>STD ID</th><th>COOT</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("COOT")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("COOT")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("DBMS")&&con!=null) {
				psDbms=con.prepareStatement(SEM4_DBMS);
				rs=psDbms.executeQuery();
				pw.println("<tr><th>STD ID</th><th>DBMS</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("DBMS")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("DBMS")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("CSC")&&con!=null) {
				psCsc=con.prepareStatement(SEM4_CSC);
				rs=psCsc.executeQuery();
				pw.println("<tr><th>STD ID</th><th>CSC</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("CSC")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("CSC")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("MT")&&con!=null) {
				psMt=con.prepareStatement(SEM4_MT);
				rs=psMt.executeQuery();
				pw.println("<tr><th>STD ID</th><th>MT</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("MT")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("MT")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("EC")&&con!=null) {
				psEc=con.prepareStatement(SEM4_EC);
				rs=psEc.executeQuery();
				pw.println("<tr><th>STD ID</th><th>EC</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("EC")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("EC")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("ELECTIVE-I")&&con!=null) {
				psElective_I=con.prepareStatement(SEM4_ELECTIVE_I);
				rs=psElective_I.executeQuery();
				pw.println("<tr><th>STD ID</th><th>ELECTIVE-I</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("ELECTIVE-I")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("ELECTIVE-I")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("AI")&&con!=null) {
				psAi=con.prepareStatement(SEM5_AI);
				rs=psAi.executeQuery();
				pw.println("<tr><th>STD ID</th><th>AI</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("AI")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("AI")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("SPM")&&con!=null) {
				psSpm=con.prepareStatement(SEM5_SPM);
				rs=psSpm.executeQuery();
				pw.println("<tr><th>STD ID</th><th>SPM</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("SPM")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("SPM")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("SAS")&&con!=null) {
				psSas=con.prepareStatement(SEM5_SAS);
				rs=psSas.executeQuery();
				pw.println("<tr><th>STD ID</th><th>SAS</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("SAS")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("SAS")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("MIS")&&con!=null) {
				psMis=con.prepareStatement(SEM5_MIS);
				rs=psMis.executeQuery();
				pw.println("<tr><th>STD ID</th><th>MIS</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("MIS")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("MIS")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else if(data.equalsIgnoreCase("ELECTIVE-II")&&con!=null) {
				psElective_II=con.prepareStatement(SEM5_ELECTIVE_II);
				rs=psElective_II.executeQuery();
				pw.println("<tr><th>STD ID</th><th>ELECTIVE-II</th></tr> ");
				while(rs.next()) {
    	    		if(rs.getInt("ID")!=0&&rs.getString("ELECTIVE-II")!=null) {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th><a href='reporturl?type=download&path="+rs.getString("ELECTIVE-II")+"'>download</a></th></tr>");
    	    		}else {
    	    			pw.println("<tr><th><a href='viewprofile?type=download&path="+rs.getInt("ID")+"'>"+rs.getInt("ID")+"</a></th><th>Not Available</th></tr>");
    	    		}	
    	    	}  	   
			}else {
				System.out.println("Invalid Statement");
			}
			pw.println("</table></center>");
		}catch(SQLException se) {
			pw.println("<center><h1 style='color:red'>Internal DB Problem</h1></center>");
		}catch(NullPointerException e) {
			pw.println("<center><h1 style='color:red'>Result Not Display</h1></center>");
		}catch(Exception e) {
			pw.println("<center><h1 style='color:red'>Result Not Display</h1></center>");
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {
		
	}
}
