package com.rsd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.rsd.bo.UploadBo;
import com.rsd.commons.DBConnection;

public class SuploadDaoImpl implements SuploadDao {
	public static final String SEM1_CO="UPDATE FIRST_SEM SET CO=? WHERE ID=?";
	public static final String SEM1_CPP="UPDATE FIRST_SEM SET CPP=? WHERE ID=?";
	public static final String SEM1_COSM="UPDATE FIRST_SEM SET COSM=? WHERE ID=?";
	public static final String SEM1_PM="UPDATE FIRST_SEM SET PM=? WHERE ID=?";
	public static final String SEM1_CK="UPDATE FIRST_SEM SET CK=? WHERE ID=?";
	
	public static final String SEM2_DS="UPDATE SECOUND_SEM SET DS=? WHERE ID=?";
	public static final String SEM2_OOP="UPDATE SECOUND_SEM SET OOP=? WHERE ID=?";
	public static final String SEM2_SAD="UPDATE SECOUND_SEM SET SAD=? WHERE ID=?";
	public static final String SEM2_DC="UPDATE SECOUND_SEM SET DC=? WHERE ID=?";
	public static final String SEM2_BS="UPDATE SECOUND_SEM SET BS=? WHERE ID=?";
	
	public static final String SEM3_OS="UPDATE THIRD_SEM SET OS=? WHERE ID=?";
	public static final String SEM3_FSDP="UPDATE THIRD_SEM SET FSDP=? WHERE ID=?";
	public static final String SEM3_JAVA="UPDATE THIRD_SEM SET JAVA=? WHERE ID=?";
	public static final String SEM3_CN="UPDATE THIRD_SEM SET CN=? WHERE ID=?";
	public static final String SEM3_COOT="UPDATE THIRD_SEM SET COOT=? WHERE ID=?";
	
	public static final String SEM4_DBMS="UPDATE FOURTH_SEM SET DBMS=? WHERE ID=?";
	public static final String SEM4_CSC="UPDATE FOURTH_SEM SET CSC=? WHERE ID=?";
	public static final String SEM4_MT="UPDATE FOURTH_SEM SET MT=? WHERE ID=?";
	public static final String SEM4_EC="UPDATE FOURTH_SEM SET EC=? WHERE ID=?";
	public static final String SEM4_ELECTIVE_I="UPDATE FOURTH_SEM SET ELECTIVE=? WHERE ID=?";
	
	public static final String SEM5_AI="UPDATE FIFTH_SEM SET AI=? WHERE ID=?";
	public static final String SEM5_SPM="UPDATE FIFTH_SEM SET SPM=? WHERE ID=?";
	public static final String SEM5_SAS="UPDATE FIFTH_SEM SET SAS=? WHERE ID=?";
	public static final String SEM5_MIS="UPDATE FIFTH_SEM SET MIS=? WHERE ID=?";
	public static final String SEM5_ELECTIVE_II="UPDATE FIFTH_SEM SET ELECTIVE=? WHERE ID=?";
	
	@Override
	public int uploadFile(UploadBo ubo) throws Exception {
		ServletContext sc=ubo.getSc();
		String data=ubo.getRole();
		String fname=ubo.getUploadLoc();
		Integer idval=ubo.getIdval();
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement psCo=null,psCpp=null,psCosm=null,psPm=null,psCk=null,psDs=null,psOop=null,psSad=null,psDc=null,psBs=null;
		PreparedStatement psOs=null,psFsdp=null,psJava=null,psCn=null,psCoot=null,psDbms=null,psCsc=null,psMt=null,psEc=null,psElective_I=null;
		PreparedStatement psAi=null,psSpm=null,psSas=null,psMis=null,psElective_II=null;
		int result=0;
		if(data.equalsIgnoreCase("CO")&&con!=null) {
			psCo=con.prepareStatement(SEM1_CO);
			psCo.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCo.setInt(2, idval);
			result=psCo.executeUpdate();
			
		}else if(data.equalsIgnoreCase("CPP")&&con!=null) {
			psCpp=con.prepareStatement(SEM1_CPP);
			psCpp.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCpp.setInt(2,idval);
			result=psCpp.executeUpdate();
			
		}else if(data.equalsIgnoreCase("COSM")&&con!=null) {
			psCosm=con.prepareStatement(SEM1_COSM);
			psCosm.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCosm.setInt(2, idval);
			result=psCosm.executeUpdate();
			
		}else if(data.equalsIgnoreCase("PM")&&con!=null) {
			psPm=con.prepareStatement(SEM1_PM);
			psPm.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psPm.setInt(2, idval);
			result=psPm.executeUpdate();
			
		}else if(data.equalsIgnoreCase("CK")&&con!=null) {
			psCk=con.prepareStatement(SEM1_CK);
			psCk.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCk.setInt(2, idval);
			result=psCk.executeUpdate();
			
		}else if(data.equalsIgnoreCase("DS")&&con!=null) {
			psDs=con.prepareStatement(SEM2_DS);
			psDs.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psDs.setInt(2, idval);
			result=psDs.executeUpdate();
			
		}else if(data.equalsIgnoreCase("OOP")&&con!=null) {
			psOop=con.prepareStatement(SEM2_OOP);
			psOop.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psOop.setInt(2, idval);
			result=psOop.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SAD")&&con!=null) {
			psSad=con.prepareStatement(SEM2_SAD);
			psSad.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psSad.setInt(2, idval);
			result=psSad.executeUpdate();
			
		}else if(data.equalsIgnoreCase("DC")&&con!=null) {
			psDc=con.prepareStatement(SEM2_DC);
			psDc.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psDc.setInt(2, idval);
			result=psDc.executeUpdate();
			
		}else if(data.equalsIgnoreCase("BS")&&con!=null) {
			psBs=con.prepareStatement(SEM2_BS);
			psBs.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psBs.setInt(2, idval);
			result=psBs.executeUpdate();
			
		}else if(data.equalsIgnoreCase("OS")&&con!=null) {
			psOs=con.prepareStatement(SEM3_OS);
			psOs.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psOs.setInt(2, idval);
			result=psOs.executeUpdate();
			
		}else if(data.equalsIgnoreCase("FSDP")&&con!=null) {
			psFsdp=con.prepareStatement(SEM3_FSDP);
			psFsdp.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psFsdp.setInt(2, idval);
			result=psFsdp.executeUpdate();
			
		}else if(data.equalsIgnoreCase("JAVA")&&con!=null) {
			psJava=con.prepareStatement(SEM3_JAVA);
			psJava.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psJava.setInt(2, idval);
			result=psJava.executeUpdate();
			
		}else if(data.equalsIgnoreCase("CN")&&con!=null) {
			psCn=con.prepareStatement(SEM3_CN);
			psCn.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCn.setInt(2, idval);
			result=psCn.executeUpdate();
			
		}else if(data.equalsIgnoreCase("COOT")&&con!=null) {
			psCoot=con.prepareStatement(SEM3_COOT);
			psCoot.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCoot.setInt(2, idval);
			result=psCoot.executeUpdate();
			
		}else if(data.equalsIgnoreCase("DBMS")&&con!=null) {
			psDbms=con.prepareStatement(SEM4_DBMS);
			psDbms.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psDbms.setInt(2, idval);
			result=psDbms.executeUpdate();
			
		}else if(data.equalsIgnoreCase("CSC")&&con!=null) {
			psCsc=con.prepareStatement(SEM4_CSC);
			psCsc.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psCsc.setInt(2, idval);
			result=psCsc.executeUpdate();
			
		}else if(data.equalsIgnoreCase("MT")&&con!=null) {
			psMt=con.prepareStatement(SEM4_MT);
			psMt.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psMt.setInt(2, idval);
			result=psMt.executeUpdate();
			
		}else if(data.equalsIgnoreCase("EC")&&con!=null) {
			psEc=con.prepareStatement(SEM4_EC);
			psEc.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psEc.setInt(2, idval);
			result=psEc.executeUpdate();
			
		}else if(data.equalsIgnoreCase("ELECTIVE-I")&&con!=null) {
			psElective_I=con.prepareStatement(SEM4_ELECTIVE_I);
			psElective_I.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psElective_I.setInt(2, idval);
			result=psElective_I.executeUpdate();
			
		}else if(data.equalsIgnoreCase("AI")&&con!=null) {
			psAi=con.prepareStatement(SEM5_AI);
			psAi.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psAi.setInt(2, idval);
			result=psAi.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SPM")&&con!=null) {
			psSpm=con.prepareStatement(SEM5_SPM);
			psSpm.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psSpm.setInt(2, idval);
			result=psSpm.executeUpdate();
			
		}else if(data.equalsIgnoreCase("SAS")&&con!=null) {
			psSas=con.prepareStatement(SEM5_SAS);
			psSas.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psSas.setInt(2, idval);
			result=psSas.executeUpdate();
			
		}else if(data.equalsIgnoreCase("MIS")&&con!=null) {
			psMis=con.prepareStatement(SEM5_MIS);
			psMis.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psMis.setInt(2, idval);
			result=psMis.executeUpdate();
			
		}else if(data.equalsIgnoreCase("ELECTIVE-II")&&con!=null) {
			psElective_II=con.prepareStatement(SEM5_ELECTIVE_II);
			psElective_II.setString(1,sc.getInitParameter("UPLOAD")+fname);
			psElective_II.setInt(2, idval);
			result=psElective_II.executeUpdate();
			
		}else {
			System.out.println("Invalid Statement");
		}
		return result;
	}

}
