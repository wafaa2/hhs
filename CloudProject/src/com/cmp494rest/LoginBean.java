package com.cmp494rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class LoginBean {

    String username = null;
    String password = null;
    boolean processError = false;
    boolean connected = false;
    public static boolean loggedInPatient = false, first = false, loggedInDoctor = false ;
    String st="null";
    DBHandler dbHandler = new DBHandler();
    String error = "";

    public static int userID;

    public String getUserusername() {
		return username;
	}

	public void setUserusername(String userusername) {
		this.username = userusername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void processRequest(HttpServletRequest request) {

        // Get the username and password.
        this.processError = false;
        if (username == null || username.equals(""))
        	setUserusername(request.getParameter("username"));
        if (password == null || password.equals(""))
        	setPassword(request.getParameter("password"));
        
        if (username == null || password == null || username.equals("")
                || password.equals("")) {
            this.processError = true;
            return;
        }
    }
	public boolean Authenticate(HttpServletRequest request) {

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String result="";
		
		if (uname != null && pass != null){
			first = false;
			int count = 0;
			Connection con = null;
			Statement statement = null;
			ResultSet resultSet = null;
	
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
				String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
				+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
				+"encrypt=true;trustServerCertificate=false;"
				+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  
	
				con = DriverManager.getConnection(connectionUrl);
	
				System.out.print("Connected");
				connected = true;
	
				String selectSql = "SELECT uid from AppUser where username = '" + uname + "' AND pwd = '"+pass+"'";
				statement = con.createStatement();
				resultSet = statement.executeQuery(selectSql);
				result=""; 
				// Print results from select statement
				while (resultSet.next()) { //returns false if empty rows
					userID = resultSet.getInt(1);
					count += 1;
				}
				
				
			} catch (Exception e) {
				System.out.print("Error message: " + e.getMessage());
			}
			
			if(count > 0){
				String selectSql2 = "SELECT * from patient where pid = '" + userID + "'";
				try {
					statement = con.createStatement();
					resultSet = statement.executeQuery(selectSql2);
					result=""; 
				
					count = 0;
					while (resultSet.next()) { //returns false if empty rows
						count += 1;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (count >0)
					loggedInPatient = true;
				else 
					loggedInDoctor = true;
				return (true);
			}
			else
				error = "<br>Username/Password combination is wrong";
		}
		return false;
		
	}
	
	public boolean getConnected()
	{
		return this.connected;
	}

	public String getST()
	{
		return this.st;
	}

	public boolean getProcessError() {
        return this.processError;
    }
	public String getError(){
		return error;
	}
    
  
}