package com.cmp494rest;

import java.sql.*;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import java.io.DataInputStream;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;


    public class SQLDatabaseConnection {  

    	public static String error = " ";
    	public static boolean loggedIn = false, first = false;
    	public static void main(String[] args) { 
    	//System.out.println(loginSuccessfulPatient("JohnBrown", "John"));
    		//insertBook(5, "book5", "author", "pub", "desc", "call", 5000);	
//    		
    		insertPatient();
    	}
    
    	public static void insertPatient() {

    		
    		String name = "JohnDooee",  username  = "JohnDooee", bloodgroup  = " ", password  = " ", gender  = " ", dob  = " ", mstatus  = " ",
    			email  = " ", mobile  = " ", emobile  = " ", diseases  = " ", allergies = " ", fdiseases  = "yes", address = " ",
    			diabetes = " ";
    		
    		if (name != " "){
    		
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

    	        System.out.println(SQL2);
    	        
    	        int result2 = con2.createStatement().executeUpdate(SQL2);

    	        System.out.println(SQL2);
    	       
    	    }catch(Exception e){ 
    	    	e.printStackTrace();
    	    } 
    		
    		}
    
    		
    	}
		 public static boolean loginSuccessfulPatient(String User, String Password){
	    		int allLib=0;
	    		try{
	    	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	    	
	    	    	String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	     	        Connection con = DriverManager.getConnection(connectionUrl); 
	    	        //System.out.print("Connected."); 
	    	        String SQL = "SELECT * FROM appuser where USERNAME = '" + User + "' and PWD = '" + Password + "' "; 
	    	        Statement stmt = con.createStatement(); 
	    	        ResultSet rs = stmt.executeQuery(SQL);
	    	        while (rs.next()) { 
	    	        	allLib+=1;
	    	        } 
	    	    }
	    		catch(Exception e){ 
	    	    	e.printStackTrace();
	    	    } 
	    		
	    		if (allLib == 0){
	    	
	    		error = "Username/Password combination is wrong";
	    		return false;
	    		}
	    		return true;
	    	}
    	    	
    		 
    	public static boolean insertBook(int id, String title, String author, String pub, String desc, String call, int isbn){
    		try{
    	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	    	
    	        String connectionUrl = "jdbc:sqlserver://g00052000libraryserver.database.windows.net:1433;database=g00052000_LibraryDB;user=g00052000@g00052000libraryserver;password=Cmp49401!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    	        Connection con = DriverManager.getConnection(connectionUrl); 
    	        //System.out.print("Connected."); 
    	        String SQL = "Insert into Books values (" + id + ", '" + title + "', '" + author + "', '" + pub + "', '" + desc +  "', '" + call +  "', " + isbn +")"; 
    	 
    	        int result = con.createStatement().executeUpdate(SQL);
    	        System.out.println(SQL);
    	       
    	    }catch(Exception e){ 
    	    	e.printStackTrace();
    	    } 
    		return true;
    	}
    	
    	public static boolean deleteBook(int id){
    		try{
    	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	    	
    	        String connectionUrl = "jdbc:sqlserver://g00052000libraryserver.database.windows.net:1433;database=g00052000_LibraryDB;user=g00052000@g00052000libraryserver;password=Cmp49401!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    	        Connection con = DriverManager.getConnection(connectionUrl); 
    	        //System.out.print("Connected."); 
    	        String SQL = "delete from Books where id = " + id; 
    	        
    	        int result = con.createStatement().executeUpdate(SQL);
    	        System.out.println(SQL);
    	       
    	    }catch(Exception e){ 
    	    	e.printStackTrace();
    	    } 
    		//System.out.print(allBooks);
    		return true;
    	}
    	
 }