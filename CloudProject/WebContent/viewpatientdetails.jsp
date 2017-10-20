<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.cmp494rest.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Patient Details</title>
<style>
aside{
    width:40%;
    float:left;
    border-right:1px dashed #aaa;
	padding: 5px;
}
.rightwidget{
	 width:59%;
	 margin-left:0px;
	 margin-right:0px;
	 float: right;
}
body{
	margin:0;
	background-color: #F3F3F3;
	font-family: "Calibri";
	font-size: medium;
	color: #717171;
}
table{
	border-collapse: collapse;
	background-color: #FFFFFF;
	font-family: "Calibri";
	font-size: medium;
	color: #717171;
	width: 85%;
	border-style: solid;
	border-color: rgba(186,186,186,1.00);
	border-width: 0.5px;
}
th{
	text-align: center;
    width: 90px;
	padding: 10px;
	border-bottom: 1px solid #ddd;
	text-align: center;
	border-width: 0.5px;
}
tr{
	border-bottom: medium none rgba(113,113,113,1.00);
	border: 1px solid #ddd;
}
td{
	font-size:14px;
	padding:10px;
	word-wrap:break-word;
	border-width: 0.05px;
	text-align: center;
	word-wrap:break-word;
}
input[type=text] {
    width:100%;
    box-sizing: border-box;
    border: 0.5px solid #ccc;
    border-radius: 4px;
    border-style: solid solid solid solid;
    padding: 8px 8px 8px 8px;
	font-family: "Calibri";
	font-size: small;
	color: black;
}
.button {
	display: inline-block;
	border-radius: 5px 5px 5px 5px;
	border: none;
	text-align: center;
	font-size: 16px;
	padding: 12px;
	width: 150px;
	margin: 0px;
	color: white;
	font-family: "Calibri";	
	background-color: #63847a;
}
button{
	display: inline-block;
	border-radius: 5px 5px 5px 5px;
	border: none;
	text-align: center;
	font-size: 16px;
	padding: 12px;
	width: 150px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 0px;
	font-family: "Calibri";
	margin-left: 100px;
}
form{
	 padding: 10px;
	 width: 100%;
}
textarea{
	width:100%; 
	border-style: solid solid solid solid; 
	background-color: white;   
	box-sizing: border-box;
	border: 0.5px solid #ccc;
	border-radius: 4px;
	padding: 10px 10px 10px 10px;
	font-family: "Calibri";
	font-size: small;
	color: black;
}
</style>

</head>
<body>

<link href="styles/headerstyles.css" rel="stylesheet" type="text/css">
<%
if (LoginBean.loggedInPatient == true){
%>
<div class="topnav" style = "margin-bottom: 40px">
	<ul>
		<li><img src = "logopatient.png" align= "center" height="70px" style= "margin-left: 70px; margin-top: 30px;"></li>
		<li style= "margin-left: 300px"><a href = "viewpatientdetails.jsp"> View Patient Details </a></li>
		<li><a href = "viewbilling.jsp"> View Billing Details </a></li>
		<li><a href = "viewguardians.jsp"> View Guardian </a></li>
		<li style= "margin-left: 50px; margin-top: 50px"><a href = "logout.jsp" class="buttonsignout"> Sign out</a></li>
	</ul>
</div>
		<%! 	
			String url_str;
			Patient patient;
			NetClientGet netc = new NetClientGet();
		%>
		<%
		url_str = "http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getPatientByID/" + LoginBean.userID;
		patient = netc.DispOnePatient(url_str);
		%>
<aside>
	<center>	
		<h2><% out.print(patient.name); %></h2>
		<i><% out.print("ID# " + LoginBean.userID); %></i>
		<br>
		<br>
		<form action="searchISBN.jsp" method="get">
			<table>
				<tr><th style="text-align: right;">Full Name</th><td style="text-align: left;"><% out.print(patient.name); %></td></tr>
				<tr><th style="text-align: right;">Date of Birth</th><td style="text-align: left;"><% out.print(patient.DOB); %></td></tr>
				<tr><th style="text-align: right;">Gender</th><td style="text-align: left;"><% out.print(patient.gender); %></td></tr>
				<tr><th style="text-align: right;">LMP</th><td style="text-align: left;"><% out.print(patient.LMP); %></td></tr>
				<tr><th style="text-align: right;">Blood Type</th><td style="text-align: left;"><% out.print(patient.bloodGroup); %></td></tr>
				<tr><th style="text-align: right;">Marital Status</th><td style="text-align: left;"><% out.print(patient.Marital_Status); %></td></tr>
			</table>
			<br>
			<table>
				<tr><th colspan="2"><center>Contact info</center></td></tr>
				<tr><th style="text-align: right;">Email</th><td style="text-align: left;"><% out.print(patient.email); %></td></tr>
				<tr><th style="text-align: right;">Mobile Number</th><td style="text-align: left;"><% out.print(patient.phonenum); %></td></tr>
				<tr><th style="text-align: right;">Emergency Contact</th><td style="text-align: left;"><% out.print(patient.emergency_contact); %></td></tr>
			</table>
			<br>
			<table>
				<tr><th colspan="2"><center>Medical Conditions</center></td></tr>
				<tr><th style="text-align: right;">Diseases</th><td style="text-align: left;"> <textarea name='description' rows="6" cols="70"><% out.print(patient.diseases); %></textarea></td></tr>
				<tr><th style="text-align: right;">Allergies</th><td style="text-align: left;"> <textarea name='description' rows="6" cols="70"><% out.print(patient.allergies); %></textarea></td></tr>
				<tr><th style="text-align: right;">Familial Diseases</th><td style="text-align: left;"> <textarea name='description' rows="6" cols="70"><% out.print(patient.familial_diseases); %></textarea></td></tr>
			</table>
		</form>		
		<br>
	</center>
</aside>


<div class="rightwidget">
	<center>	
		
		<br>
		<br>
		<!-- Vital Signs -->
			<table>
				<tr style="background-color: #37a4ba; color: white"><th colspan="5"><center>Vital Signs</center></th></tr>
				<tr><th>Date</th><th>Blood Pressure</th><th>Pulse Rate</th><th>Respiration</th></th><th>Body Temp.</th></tr>
				<% 
				String output6 = netc.getVitals("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getVitalsByPatientId/" + LoginBean.userID);
				if( !output6.equals(null) || !output6.equals(""))
				{
					out.print(output6);
				}%>
			</table>
		<br>
		<br>
		
		<!-- Physical Examination -->
			<table>
				<tr style="background-color: #37a4ba; color: white"><th colspan="5"><center>Physical Examination</center></th></tr>
				<tr><th>Date</th><th>Weight</th><th>Height</th></tr>
				<% 
				String output5 = netc.getPhysicalExam("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getExaminationByPatientId/" + LoginBean.userID);
				if( !output5.equals(null) || !output5.equals(""))
				{
					out.print(output5);
				}%>
				
			</table>
		<br>	
		<br>
		
		<!-- Visits -->
			<table>
				<tr style="background-color: #37a4ba; color: white"><th colspan="5"><center>Visits</center></th></tr>
				<tr><th>Date</th><th>Type</th><th>Symptoms</th><th>Treatement</th><th>Notes</th></tr>
				<% 
				String output4 = netc.getVisits("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getVisitsByPatientId/" + LoginBean.userID);
				if( !output4.equals(null) || !output4.equals(""))
				{
					out.print(output4);
				}%>
				
				
			</table>
		<br>
		<br>
		
		<!-- Medications -->
			<table>
				<tr style="background-color: #37a4ba; color: white"><th colspan="5"><center>Medications</center></th></tr>
				<tr><th>Start Date</th><th>End Date</th><th>Name</th><th>Dose</th><th>Notes</th></tr>
				<% 
				String output3 = netc.DispMedication("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getPerscribed_MedicationByPatientId/" + LoginBean.userID);
				if( !output3.equals(null) || !output3.equals(""))
				{
					out.print(output3);
				}%>				
			</table>
		<br>
		<br>
		
		<!-- Imaging Reports -->
			<table>
				<tr style="background-color: #37a4ba; color: white"><th colspan="5"><center>Imaging Reports</center></th></tr>
				<tr><th>Date</th><th>Img. ID.</th><th>File</th><th>Type</th><th>Notes</th></tr>
				<% 
				String output = netc.getImage("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getImageById/" + LoginBean.userID);
				if( !output.equals(null) || !output.equals(""))
				{
					out.print(output);
				}%>
				
			</table>
		<br>
		<br>
		
		<!-- Lab Reports -->
			<table>
				<tr style="background-color: #37a4ba; color: white"><th colspan="5"><center>Lab Reports</center></th></tr>
				<tr><th>Date</th><th>Report. ID.</th><th>File</th><th>Notes</th></tr>
				<%
				String output2 = netc.DispLabTest("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getTestByPatientId/" + LoginBean.userID);
				if( !output2.equals(null) || !output2.equals(""))
				{
					out.print(output2);
				}%>
				
			</table>
		<br>
		
	</center>
</div>
<%
} else
	response.sendRedirect("signinpatient.jsp");
%>
</body>
</html></html>