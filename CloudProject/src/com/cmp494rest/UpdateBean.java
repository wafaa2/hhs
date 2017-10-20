package com.cmp494rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class UpdateBean {

    public static String error = "";

    
	public boolean updatePatient(HttpServletRequest request, int pid) {

		String name = " ",  username  = " ", bloodgroup  = " ", password  = " ", gender  = " ", dob  = " ", mstatus  = " ",
			email  = " ", mobile  = " ", emobile  = " ", diseases  = " ", allergies = " ", fdiseases  = " ", address = " ",
			diabetes = " ", lmp = " ";
		
		name = request.getParameter("name");
		username = request.getParameter("username");
		bloodgroup = request.getParameter("bloodgroup");
		password = request.getParameter("password");
		gender = request.getParameter("gender");
		dob = request.getParameter("dob");
		mstatus = request.getParameter("mstatus");
		email = request.getParameter("email");
		mobile = request.getParameter("mobile");
		emobile = request.getParameter("emobile");
		diseases = request.getParameter("diseases");
		allergies = request.getParameter("allergies");
		fdiseases = request.getParameter("fdiseases");
		address = request.getParameter("address");
		lmp = request.getParameter("lmp");
		
		if (name != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
	        String SQL = "Update AppUser set " 			+ "uname = '" + name + "', " 
										        		+ "email = '" + email    + "', " 
										        		+ "phonenum = '" + mobile   + "', "
										        		+ "emergencynum = '" + emobile + "' "
										        		+ "where uid = '" + pid + "'"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	        con.close();
	        
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
			Connection con2 = DriverManager.getConnection(connectionUrl); 
			String SQL2 = "update patient set " 
	        		+ "bloodgroup = '" + bloodgroup + "', " 
	        		+ "allergies = '" + allergies  + "', " 
	        		+ "diabetes = '" + diabetes 	 + "', " 
	        		+ "date_of_birth = '" + dob        + "', " 
	        		+ "gender = '" + gender     + "', " 
	        		+ "marital_status = '" + mstatus    + "', "
	        		+ "diseases = '" + diseases   + "', "
	        		+ "lmp = '" + lmp   + "', "
	        		+ "familial_diseases = '" + fdiseases  + "' "
	        		+ "where pid = '" + pid + "'"; 

	        int result2 = con2.createStatement().executeUpdate(SQL2);

	        System.out.println(SQL2);
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}	
	return false;
		
	}
}