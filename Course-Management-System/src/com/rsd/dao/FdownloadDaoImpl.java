package com.rsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rsd.commons.DBConnection;

public class FdownloadDaoImpl implements FdownloadDao {
	public static final String SEM1_CO="SELECT CO FROM FIRST_SEM_FACULTY";
	public static final String SEM1_CPP="SELECT CPP FROM FIRST_SEM_FACULTY";
	public static final String SEM1_COSM="SELECT COSM FROM FIRST_SEM_FACULTY";
	public static final String SEM1_PM="SELECT PM FROM FIRST_SEM_FACULTY";
	public static final String SEM1_CK="SELECT CK FROM FIRST_SEM_FACULTY";
	
	public static final String SEM2_DS="SELECT DS FROM SECOUND_SEM_FACULTY";
	public static final String SEM2_OOP="SELECT OOP FROM SECOUND_SEM_FACULTY";
	public static final String SEM2_SAD="SELECT SAD FROM SECOUND_SEM_FACULTY";
	public static final String SEM2_DC="SELECT DC FROM SECOUND_SEM_FACULTY";
	public static final String SEM2_BS="SELECT BS FROM SECOUND_SEM_FACULTY";
	
	public static final String SEM3_OS="SELECT OS FROM THIRD_SEM_FACULTY";
	public static final String SEM3_FSDP="SELECT FSDP FROM THIRD_SEM_FACULTY";
	public static final String SEM3_JAVA="SELECT JAVA FROM THIRD_SEM_FACULTY";
	public static final String SEM3_CN="SELECT CN FROM THIRD_SEM_FACULTY";
	public static final String SEM3_COOT="SELECT COOT FROM THIRD_SEM_FACULTY";
	
	public static final String SEM4_DBMS="SELECT DBMS FROM FOURTH_SEM_FACULTY";
	public static final String SEM4_CSC="SELECT CSC FROM FOURTH_SEM_FACULTY";
	public static final String SEM4_MT="SELECT MT FROM FOURTH_SEM_FACULTY";
	public static final String SEM4_EC="SELECT EC FROM FOURTH_SEM_FACULTY";
	public static final String SEM4_ELECTIVE_I="SELECT ELECTIVE FROM FOURTH_SEM_FACULTY";
	
	public static final String SEM5_AI="SELECT AI FROM FIFTH_SEM_FACULTY";
	public static final String SEM5_SPM="SELECT SPM FROM FIFTH_SEM_FACULTY";
	public static final String SEM5_SAS="SELECT SAS FROM FIFTH_SEM_FACULTY";
	public static final String SEM5_MIS="SELECT MIS FROM FIFTH_SEM_FACULTY";
	public static final String SEM5_ELECTIVE_II="SELECT ELECTIVE FROM FIFTH_SEM_FACULTY";
	
	@Override
	public String getFile(String data) throws Exception {
		Connection con=null;
		con=DBConnection.getConnection();
		ResultSet rs=null;
		PreparedStatement psCo=null,psCpp=null,psCosm=null,psPm=null,psCk=null,psDs=null,psOop=null,psSad=null,psDc=null,psBs=null;
		PreparedStatement psOs=null,psFsdp=null,psJava=null,psCn=null,psCoot=null,psDbms=null,psCsc=null,psMt=null,psEc=null,psElective_I=null;
		PreparedStatement psAi=null,psSpm=null,psSas=null,psMis=null,psElective_II=null;
		String result=null;
		if(data.equalsIgnoreCase("CO")&&con!=null) {
			psCo=con.prepareStatement(SEM1_CO);
			rs=psCo.executeQuery();
			while(rs.next()) {
				result=rs.getString("CO");
			}
			
		}else if(data.equalsIgnoreCase("CPP")&&con!=null) {
			psCpp=con.prepareStatement(SEM1_CPP);
			rs=psCpp.executeQuery();
			while(rs.next()) {
				result=rs.getString("CPP");
			}
			
		}else if(data.equalsIgnoreCase("COSM")&&con!=null) {
			psCosm=con.prepareStatement(SEM1_COSM);
			rs=psCosm.executeQuery();
			while(rs.next()) {
				result=rs.getString("COSM");
			}
			
		}else if(data.equalsIgnoreCase("PM")&&con!=null) {
			psPm=con.prepareStatement(SEM1_PM);
			rs=psPm.executeQuery();
			while(rs.next()) {
				result=rs.getString("PM");
			}
			
		}else if(data.equalsIgnoreCase("CK")&&con!=null) {
			psCk=con.prepareStatement(SEM1_CK);
			rs=psCk.executeQuery();
			while(rs.next()) {
				result=rs.getString("CK");
			}
			
		}else if(data.equalsIgnoreCase("DS")&&con!=null) {
			psDs=con.prepareStatement(SEM2_DS);
			rs=psDs.executeQuery();
			while(rs.next()) {
				result=rs.getString("DS");
			}
			
		}else if(data.equalsIgnoreCase("OOP")&&con!=null) {
			psOop=con.prepareStatement(SEM2_OOP);
			rs=psOop.executeQuery();
			while(rs.next()) {
				result=rs.getString("OOP");
			}
			
		}else if(data.equalsIgnoreCase("SAD")&&con!=null) {
			psSad=con.prepareStatement(SEM2_SAD);
			rs=psSad.executeQuery();
			while(rs.next()) {
				result=rs.getString("SAD");
			}
			
		}else if(data.equalsIgnoreCase("DC")&&con!=null) {
			psDc=con.prepareStatement(SEM2_DC);
			rs=psDc.executeQuery();
			while(rs.next()) {
				result=rs.getString("DC");
			}
			
		}else if(data.equalsIgnoreCase("BS")&&con!=null) {
			psBs=con.prepareStatement(SEM2_BS);
			rs=psBs.executeQuery();
			while(rs.next()) {
				result=rs.getString("BS");
			}
			
		}else if(data.equalsIgnoreCase("OS")&&con!=null) {
			psOs=con.prepareStatement(SEM3_OS);
			rs=psOs.executeQuery();
			while(rs.next()) {
				result=rs.getString("OS");
			}
		}else if(data.equalsIgnoreCase("FSDP")&&con!=null) {
			psFsdp=con.prepareStatement(SEM3_FSDP);
			rs=psFsdp.executeQuery();
			while(rs.next()) {
				result=rs.getString("FSDP");
			}
			
		}else if(data.equalsIgnoreCase("JAVA")&&con!=null) {
			psJava=con.prepareStatement(SEM3_JAVA);
			rs=psJava.executeQuery();
			while(rs.next()) {
				result=rs.getString("JAVA");
			}
			
		}else if(data.equalsIgnoreCase("CN")&&con!=null) {
			psCn=con.prepareStatement(SEM3_CN);
			rs=psCn.executeQuery();
			while(rs.next()) {
				result=rs.getString("CN");
			}
			
		}else if(data.equalsIgnoreCase("COOT")&&con!=null) {
			psCoot=con.prepareStatement(SEM3_COOT);
			rs=psCoot.executeQuery();
			while(rs.next()) {
				result=rs.getString("COOT");
			}
			
		}else if(data.equalsIgnoreCase("DBMS")&&con!=null) {
			psDbms=con.prepareStatement(SEM4_DBMS);
			rs=psDbms.executeQuery();
			while(rs.next()) {
				result=rs.getString("DBMS");
			}
			
		}else if(data.equalsIgnoreCase("CSC")&&con!=null) {
			psCsc=con.prepareStatement(SEM4_CSC);
			rs=psCsc.executeQuery();
			while(rs.next()) {
				result=rs.getString("CSC");
			}
			
		}else if(data.equalsIgnoreCase("MT")&&con!=null) {
			psMt=con.prepareStatement(SEM4_MT);
			rs=psMt.executeQuery();
			while(rs.next()) {
				result=rs.getString("MT");
			}
			
		}else if(data.equalsIgnoreCase("EC")&&con!=null) {
			psEc=con.prepareStatement(SEM4_EC);
			rs=psEc.executeQuery();
			while(rs.next()) {
				result=rs.getString("EC");
			}
			
		}else if(data.equalsIgnoreCase("ELECTIVE-I")&&con!=null) {
			psElective_I=con.prepareStatement(SEM4_ELECTIVE_I);
			rs=psElective_I.executeQuery();
			while(rs.next()) {
				result=rs.getString("ELECTIVE");
			}
			
		}else if(data.equalsIgnoreCase("AI")&&con!=null) {
			psAi=con.prepareStatement(SEM5_AI);
			rs=psAi.executeQuery();
			while(rs.next()) {
				result=rs.getString("AI");
			}
			
		}else if(data.equalsIgnoreCase("SPM")&&con!=null) {
			psSpm=con.prepareStatement(SEM5_SPM);
			rs=psSpm.executeQuery();
			while(rs.next()) {
				result=rs.getString("SPM");
			}
			
		}else if(data.equalsIgnoreCase("SAS")&&con!=null) {
			psSas=con.prepareStatement(SEM5_SAS);
			rs=psSas.executeQuery();
			while(rs.next()) {
				result=rs.getString("SAS");
			}
			
		}else if(data.equalsIgnoreCase("MIS")&&con!=null) {
			psMis=con.prepareStatement(SEM5_MIS);
			rs=psMis.executeQuery();
			while(rs.next()) {
				result=rs.getString("MIS");
			}	
		}else if(data.equalsIgnoreCase("ELECTIVE-II")&&con!=null) {
			psElective_II=con.prepareStatement(SEM5_ELECTIVE_II);
			rs=psElective_II.executeQuery();
			while(rs.next()) {
				result=rs.getString("ELECTIVE");
			}
		}else {
			System.out.println("Invalid Statement");
		}
		return result;
	}
}
