package com.cmp494rest;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.*;

public class DBHandler {
	
	private Connection con = null;
	private Statement statement = null;
		
	public Boolean OpenConnectiton()  {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://teamaserver.database.windows.net:1433;"
			+"database=EHRDatabase;user=TeamA@teamaserver;password=bwan@123;"
			+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;loginTimeout=30;";  

				con = DriverManager.getConnection(connectionUrl);

				System.out.println("Connected");
				
			} catch (Exception e) {
				System.out.print("Error message: " + e.getMessage());
				return false;
			}
		
		return true;
	}
	
	public Boolean CloseConnection()
	{
		  // Close the connections after the data has been handled.  
        if (con != null) try { con.close(); } catch(Exception e) {
        	System.out.print("Error message: " + e.getMessage());
        	return false;
        }  
		
		return true;
	}
		
	public Boolean Table(String statment, String selection, String table, String attributes, String condition, String extra )
	{
		if(statment.equals("select"))
		{
			
		}
		else
		{
			try {
				String Sql = statement + selection + "FROM" + table + attributes + condition + extra;
				statement = con.createStatement();

				int result = statement.executeUpdate(Sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("Error message: " + e.getMessage());
				return false;

			}  
			
		}
		
		return true;
	}
	
	
}