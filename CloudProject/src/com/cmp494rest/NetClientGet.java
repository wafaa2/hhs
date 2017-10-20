package com.cmp494rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NetClientGet {
	
	static String filepath;
	
	
	
	public static String getFilepath() {
		return filepath;
	}


	public static void setFilepath(String filepath) {
		NetClientGet.filepath = filepath;
	}


	public void callRest(String url_str) {

		try {
			URL url = new URL(url_str);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public Patient DispOnePatient(String url_str)
	{
	   String output = null;
	   String notFormatted = "";
	   String Lines[] = null;
	   String values[]=null;
	   String formatted ="";
	   Patient patient = new Patient();
	    try
	    {
	      URL url = new URL(url_str);
	      System.out.println(url_str);
	      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	      if (conn.getResponseCode() != 200) {
	        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	      }
	      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	      while((output = br.readLine()) != null)
	      {
	        notFormatted += output;
	        
	      }

	      Lines = notFormatted.split("<hr>");
	      formatted="";
	      
	     for(int i=0; i <Lines.length; i++)
	      {
	    	  values = Lines[i].split("<br>");
	    	  
	    	
	    	  patient.ID = values[0];
	    	  patient.name = values[1];
	    	  patient.DOB = values[13];
	    	  patient.gender = values[14];
	    	  patient.bloodGroup = values[10];
	    	  patient.phonenum = values[5];
	    	  patient.emergency_contact = values[6];
	    	  patient.email = values[7];
	    	  patient.allergies = values[11];
	    	  patient.LMP = values[15];
	    	  patient.Marital_Status = values[16];
    	      patient.diseases = values[17];
	    	  patient.familial_diseases = values[18];
	    	  
	      }
	      
	      conn.disconnect();
	    }
	    catch (MalformedURLException e)
	    { e.printStackTrace(); }
	    catch (IOException e)
	    { e.printStackTrace();}
	    
	    System.out.println(patient.name);
	    return patient;
	  }
	  
	
	
	
//	public String DispPatients(String url_str)
//	{
//		 String output = null;
//		   String notFormatted = "";
//		   String Lines[] = null;
//		   String values[]=null;
//		   String formatted ="";
//
//		    try
//		    {
//		      URL url = new URL(url_str);
//		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//		      if (conn.getResponseCode() != 200) {
//		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//		      }
//		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    
//		      while((output = br.readLine()) != null)
//		      {
//		        notFormatted += output;
//		        
//		      }
//		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";
//
//		      
//		      Lines = notFormatted.split("<hr>");
//		      formatted="";
//
//		      for(int i=0; i <Lines.length; i++)
//		      {
//		    	  values = Lines[i].split("<br>");
//		    	  String tr = "<tr onclick=\"document.location = 'editpatientdetails.jsp?pid=" + values[0] + "';\">";
//		    	  formatted += tr + "<td>"+values[0]+"</td><td>"+values[1]+"</td><td>"+values[5]+"</td><td>"+values[7]+"</td><td>"
//	    			  		+values[13]+"</td><td>"+values[14] + "</td></tr>";
//		    	  System.out.println(formatted);
//		      }
//
//		      conn.disconnect();
//		    }
//	    catch (MalformedURLException e)
//	    { e.printStackTrace();}
//	    catch (IOException e)
//	    { e.printStackTrace();}
//	    return formatted;
//	  }
//	
	
	public String DispPatients(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      if (notFormatted == ""){
		    	  return "<tr><td colspan ='6'>No patients were found</td></tr>";
		      }
		      
		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  String tr = "<tr onclick=\"document.location = 'editpatientdetails.jsp?pid=" + values[0] + "';\">";
		    	  formatted += tr + "<td>"+values[0]+"</td><td>"+values[1]+"</td><td>"+values[5]+"</td><td>"+values[7]+"</td><td>"
	    			  		+values[13]+"</td><td>"+values[14] + "</td></tr>";
		    	  System.out.println(formatted);
		      }

		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	public String DispOneDoctor(String url_str)
	{
	   String output = null;
	   String notFormatted = "";
	   String Lines[] = null;
	   String values[]=null;
	   String formatted ="";

	    try
	    {
	      URL url = new URL(url_str);
	      System.out.println(url_str);
	      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	      if (conn.getResponseCode() != 200) {
	        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	      }
	      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	      while((output = br.readLine()) != null)
	      {
	        notFormatted += output;
	        
	      }
	      Lines = notFormatted.split("<hr>");
	      formatted="";

	      for(int i=0; i <Lines.length; i++)
	      {
	    	  values = Lines[i].split("<br>");
	    	  formatted += "<tr><td>"+values[0]+"</td><td>"+values[1]+"</td><td>"+values[2]+"</td><td>"
	    			  		+values[3]+"</td><td>"+values[4]+"</td><td>"+values[5]+"</td><td>"+values[6]+"</td><td>"
	    			  		+values[7]+"</td><td>"+values[8]+"</td><td>"+values[9]+"</td><td>"+values[10]+"</td><td>"
	    			  		+values[11]+"</td></tr>";
	      }
	      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

	      
	      conn.disconnect();
	    }
	    catch (MalformedURLException e)
	    { e.printStackTrace(); }
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	  
	public String DispDoctors(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  formatted += "<tr><td>"+values[0]+"</td><td>"+values[1]+"</td><td>"+values[2]+"</td><td>"
	    			  		+values[3]+"</td><td>"+values[4]+"</td><td>"+values[5]+"</td><td>"+values[6]+"</td><td>"
	    			  		+values[7]+"</td><td>"+values[8]+"</td><td>"+values[9]+"</td><td>"+values[10]+"</td><td>"
	    			  		+values[11]+"</td></tr>";
		      }
		      
		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	public String DispOneGuardian(String url_str)
	{
	   String output = null;
	   String notFormatted = "";
	   String Lines[] = null;
	   String values[]=null;
	   String formatted ="";

	    try
	    {
	      URL url = new URL(url_str);
	      System.out.println(url_str);
	      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	      if (conn.getResponseCode() != 200) {
	        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	      }
	      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	      while((output = br.readLine()) != null)
	      {
	        notFormatted += output;
	        
	      }
	      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

	      Lines = notFormatted.split("<hr>");
	      formatted="";

	      for(int i=0; i <Lines.length; i++)
	      {
	    	  values = Lines[i].split("<br>");
	    	  formatted += "<tr><td>"+values[0]+"</td><td>"+values[1]+"</td><td>"+values[2]+"</td><td>"
	    			  		+values[3]+"</td><td>"+values[4]+"</td><td>"+values[5]+"</td><td>"+values[6]+"</td><td>"
	    			  		+values[7]+"</td><td>"+values[8]+"</td></tr>";
	      }
	      
	      conn.disconnect();
	    }
	    catch (MalformedURLException e)
	    { e.printStackTrace(); }
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	
	public String DispGuardians(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  String tr = "<tr>";
		    	  //name, address, phone#,email, relation
		    	  formatted += tr + "<td>"+values[1]+"</td><td>"+values[4]+"</td><td>"+values[5]+"</td><td>"+values[7]+"</td><td>"
	    			  		+values[10]+ "</td></tr>";
		    	  System.out.println(formatted);
		      }

		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	public String getImage(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		   try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  String tr = "<tr>";
		    	  //date, no, link, type, notes
		    	  formatted += tr + "<td>"+values[4]+"</td><td>"+values[0]+"</td><td><a href='download.jsp'>File"+"</a></td><td>"+values[2]+"</td><td>"
	    			  		+values[5]+"</td></tr>";
		    	  setFilepath(values[3]);
		    	  
		    	  System.out.println(formatted);
		      }

		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	public String getVitals(String url_str)
	{
	   String output = null;
	   String notFormatted = "";
	   String Lines[] = null;
	   String values[]=null;
	   String formatted ="";

	    try
	    {
	      URL url = new URL(url_str);
	      System.out.println(url_str);
	      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	      if (conn.getResponseCode() != 200) {
	        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	      }
	      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	      while((output = br.readLine()) != null)
	      {
	        notFormatted += output;
	        
	      }
	      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

	      Lines = notFormatted.split("<hr>");
	      formatted="";
	     for(int i=0; i <Lines.length; i++)
	      {
	    	  values = Lines[i].split("<br>");
	    	  formatted += "<tr><td>"+values[5]+"</td><td>"+values[1]+"</td><td>"+values[2]+"</td><td>"
	    			  		+values[4]+"</td><td>"+values[3]+"</td></tr>";
	      }
	     	      
	      conn.disconnect();
	    }
	    catch (MalformedURLException e)
	    { e.printStackTrace(); }
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }


	public String getBills(String url_str)
	{
	   String output = null;
	   String notFormatted = "";
	   String Lines[] = null;
	   String values[]=null;
	   String formatted ="";

	    try
	    {
	      URL url = new URL(url_str);
	      System.out.println(url_str);
	      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	      if (conn.getResponseCode() != 200) {
	        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	      }
	      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	      while((output = br.readLine()) != null)
	      {
	        notFormatted += output;
	        
	      }
	      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

	      Lines = notFormatted.split("<hr>");
	      formatted="";
	     for(int i=0; i <Lines.length; i++)
	      {
	    	  values = Lines[i].split("<br>");
	    	  formatted += "<tr><td>"+"22/4/2016"+values[0]+"</td><td>"+ "" +"</td><td>"+values[1]+"</td><td>"+ " " +"</td></tr>";
	      }
	     	      
	      conn.disconnect();
	    }
	    catch (MalformedURLException e)
	    { e.printStackTrace(); }
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }

	public String DispMedication(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";
	
		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  formatted += "<tr><td>"+values[3]+"</td><td>"+values[4]+"</td><td>"+values[2]+"</td><td>"
		    	  +values[5]+"</td><td>"+values[6]+"</td></tr>";
		    	  
		      }
		      
		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	public String DispLabTest(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[0].split("<br>");
		    	  formatted += "<tr><td>"+"Date"+"</td><td>"+values[0]+"</td><td><a href='download.jsp'>File"+"</a></td><td>"
		    	  +values[2]+"</td></tr>";
		      }
	    	  setFilepath(values[3]);

		      
		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }

	public String getVisits(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";
		      
		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  formatted += "<tr><td>"+values[0]+"</td><td>"+values[2]+"</td><td>"+values[3]+"</td><td>"
		    	  +values[4] +"</td><td>" +values[2]+"</td></tr>";
		      }
		      
		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }
	
	public String getPhysicalExam(String url_str)
	{
		 String output = null;
		   String notFormatted = "";
		   String Lines[] = null;
		   String values[]=null;
		   String formatted ="";

		    try
		    {
		      URL url = new URL(url_str);
		      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		      if (conn.getResponseCode() != 200) {
		        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		      }
		      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		      while((output = br.readLine()) != null)
		      {
		        notFormatted += output;
		        
		      }
		      if(notFormatted == "") return "<tr><td>No records found</td></tr>";

		      Lines = notFormatted.split("<hr>");
		      formatted="";

		      for(int i=0; i <Lines.length; i++)
		      {
		    	  values = Lines[i].split("<br>");
		    	  formatted += "<tr><td>"+values[3]+"</td><td>"+values[1]+"</td><td>"+values[2]+"</td></tr>";
		      }
		      
		      conn.disconnect();
		    }
	    catch (MalformedURLException e)
	    { e.printStackTrace();}
	    catch (IOException e)
	    { e.printStackTrace();}
	    return formatted;
	  }

	public static void main(String[] args) {
		String url_str = "http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getTestByPatientId/21";
//		//String url2 = "http://54536homework1.azurewebsites.net/hw1/rest/Lib/SearchBook/"+"9781501129742";
		NetClientGet netc = new NetClientGet();
//		
////		//netc.callRest(url_str);
//		//System.out.println(netc.DispOneBook(url2));
//		
		String res=netc.getPhysicalExam(url_str);
		System.out.println(res);
//
	}

}