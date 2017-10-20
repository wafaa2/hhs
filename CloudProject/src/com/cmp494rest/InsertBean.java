package com.cmp494rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class InsertBean {

    boolean processError = false;
    boolean connected = false;
    public static boolean loggedIn = false, first = false, uploaded = false;
    DBHandler dbHandler = new DBHandler();
    public static String error = "";

    
    public static String imagePath = "";
    public static String imageFile = "No file Uploaded";
    
	public boolean insertPatient(HttpServletRequest request) {

		String name = " ",  username  = " ", bloodgroup  = " ", password  = " ", gender  = " ", dob  = " ", mstatus  = " ",
			email  = " ", mobile  = " ", emobile  = " ", diseases  = " ", allergies = " ", fdiseases  = " ", address = " ",
			diabetes = " ";
		
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
		
		if (name != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
	        String SQL = "Insert into AppUser (uname, username, pwd, uaddress, email, phonenum, emergencynum) values ('" 
										        		+ name + "', '" 
										        		+ username + "', '" 
										        		+ password + "', '" 
										        		+ address  + "', '" 
										        		+ email    + "', '" 
										        		+ mobile   + "', '"
										        		+ emobile  + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	        con.close();
	        
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
			Connection con2 = DriverManager.getConnection(connectionUrl); 
			String SQL2 = "Insert into patient (pid, bloodgroup, allergies, diabetes, date_of_birth, gender, marital_status, diseases, familial_diseases) values (" 
	        		+ "(select uid from appuser where username = '" + username + "'), '"
	        		+ bloodgroup + "', '" 
	        		+ allergies  + "', '" 
	        		+ diabetes 	 + "', '" 
	        		+ dob        + "', '" 
	        		+ gender     + "', '" 
	        		+ mstatus    + "', '"
	        		+ diseases   + "', '"
	        		+ fdiseases  + "')"; 

	        int result2 = con2.createStatement().executeUpdate(SQL2);

	        System.out.println(SQL2);
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}	
	return false;
		
	}
	public boolean insertGuardian(HttpServletRequest request, int pid) {
		
		String name = " ",  email  = " ", username  = " ", password  = " ", mobile  = " ", address  = " ", relation  = " ";
		
		name = request.getParameter("name");
		username = request.getParameter("username");
		password = request.getParameter("password");
		email = request.getParameter("email");
		mobile = request.getParameter("mobile");
		address = request.getParameter("address");
		relation = request.getParameter("relationship");
		
		if (name != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
	        String SQL = "Insert into AppUser (uname, username, pwd, uaddress, email, phonenum) values ('" 
										        		+ name + "', '" 
										        		+ username + "', '" 
										        		+ password + "', '" 
										        		+ address  + "', '" 
										        		+ email    + "', '" 
										        		+ mobile   + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	        con.close();
	        
	        Connection con2 = DriverManager.getConnection(connectionUrl); 
	        
	        String SQL2 = "Insert into gaurdian (gid) values (" 
	        		+ "(select uid from appuser where username = '" + username + "'))"; 

	        int result2 = con2.createStatement().executeUpdate(SQL2);

	        System.out.println(SQL2);
	       
	        
	        Connection con3 = DriverManager.getConnection(connectionUrl); 
	        
	        String SQL3 = "Insert into Pt_Gd_relationship (gdid, pid, relationship) values (" 
	        		+ "(select uid from appuser where username = '" + username + "'), "
	        		+ pid + ", '" 
	        		+ relation  + "')"; 

	        int result3 = con3.createStatement().executeUpdate(SQL2);

	        System.out.println(SQL3);
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}
	
	public boolean insertVitalSigns(HttpServletRequest request, int pid) {

		String date = " ",  pressure  = " ", rate  = " ", resp  = " ", temp  = " ";
		
		date = request.getParameter("vdate");
		pressure = request.getParameter("pressure");
		rate = request.getParameter("rate");
		resp = request.getParameter("resp");
		temp = request.getParameter("temp");
		
		if (date != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
	        String SQL = "Insert into vital_signs (ptnid, blood_pressure, body_temp, pulse_rate, respiration_rate, Date_Of_Examination) values ('" 
										        		+ pid + "', '" 
										        		+ pressure + "', '" 
										        		+ temp + "', '" 
										        		+ rate  + "', '" 
										        		+ resp    + "', '" 
										        		+ date   + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}
	public String getError(){
		return error;
	}

	public boolean insertPhysical(HttpServletRequest request, int pid) {

		String date = " ",  weight  = " ", height  = " ";
		
		date = request.getParameter("pdate");
		weight = request.getParameter("weight");
		height = request.getParameter("height");
		
		if (date != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
	        String SQL = "Insert into physical_examination (ptnid, wieght, hieght, exam_date) values ('" 
										        		+ pid    + "', '" 
										        		+ weight + "', '" 
										        		+ height + "', '" 
										        		+ date   + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}
	public boolean insertVisits(HttpServletRequest request, int pid) {

		String description = " ", type = " ", date = " ", emergency = " ", checkup  = " ", symptoms  = " ", treatment  = " ", notes  = " ", procedural = " ", consultation = " ", overnight = " ";
		
		date = request.getParameter("vidate");
		symptoms = request.getParameter("vsymptoms");
		treatment = request.getParameter("vtreatment");
		notes = request.getParameter("vnotes");
		
		if (date != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
	        String SQL = "Insert into visits (Date_AND_Time, description, pid, symptoms, treatment) values ('" 
										        		+ date    + "', '" 
										        		+ notes + "', '"
										        		+ pid + "', '" 
										        		+ symptoms + "', '" 
										        		+ treatment   + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        
	   

	        result = con.createStatement().executeUpdate(SQL);

	        System.out.println(SQL);
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}
	
	public boolean insertMedication(HttpServletRequest request, int pid, int drid) {

		String startdate  = " ", enddate  = " ", medname  = " ", dose = " ",  mednotes  = " ", doctor = " ";
	
		startdate = request.getParameter("startdate");
		enddate = request.getParameter("enddate");
		medname = request.getParameter("medname");
		mednotes = request.getParameter("mednotes");
		dose = request.getParameter("dose");
		doctor = request.getParameter("doctor");
		
		if (medname != null && doctor != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
			String SQL = "Insert into medication (medname) values ('" 
	        		+ medname  + "')"; 
			
			int result = con.createStatement().executeUpdate(SQL);
		    System.out.println(SQL);
	        
		    SQL = "Insert into Perscribed_Medication (ptnid, drid, startdate, enddate, med, doses, notes) values (" 
										        		+ pid    + ", " 
										        		+ drid + ", '" 
										        		+ startdate + "', '" 
										        		+ enddate + "', '" 
										        		+ medname + "', '" 
										        		+ dose + "', '" 
										        		+ mednotes + "')"; 
	 
	        result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}
	
	public boolean insertImage(HttpServletRequest request, int pid) {

		String idate  = " ", imageid  = " ", itype  = " ", inotes = " ";
	
		idate = request.getParameter("idate");
		imageid = request.getParameter("imageid");
		itype = request.getParameter("itype");
		inotes = request.getParameter("inotes");
		
		if (imageid != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
			
	
		    String SQL = "Insert into images (ptnid, imageno, imagetype, image_path, date_image, notes) values ('" 
										        		+ pid     + "', '" 
										        		+ imageid + "', '" 
										        		+ itype + "', '" 
										        		+ imagePath + "', '" 
										        		+ idate + "', '" 
										        		+ inotes + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	        imageFile = "No file Uploaded";
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}
	
	public boolean insertReport(HttpServletRequest request, int pid) {

		String rdate  = " ", reportid  = " ",  rnotes = " ";
	
		rdate = request.getParameter("rdate");
		reportid = request.getParameter("reportid");
		rnotes = request.getParameter("rnotes");
		
		if (reportid != null){
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
			
			Connection con = DriverManager.getConnection(connectionUrl); 
	        //System.out.print("Connected."); 
			
	
		    String SQL = "Insert into lab_tests (ptnid, fileid, notes, filelink) values ('" 
										        		+ pid     + "', '" 
										        		+ reportid + "', '" 
										        		+ rnotes + "', '" 
										        		+ imagePath + "')"; 
	 
	        int result = con.createStatement().executeUpdate(SQL);
	        System.out.println(SQL);
	        imageFile = "No file Uploaded";
	       
	    }catch(Exception e){ 
	    	e.printStackTrace();
	    } 
		return true;
		}
	return false;
		
	}

}
    
  
