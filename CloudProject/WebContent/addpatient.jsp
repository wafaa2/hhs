<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.cmp494rest.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Patient</title>
<style>
aside{
    width:40%;
    float:left;
	padding: 5px;
	margin-left:100px;
}
.rightwidget{
	width:40%;
	margin-left:0px;
	margin-right:100px;
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
	border-radius: 4px 4px 4px 4px;
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
	border-radius: 4px 4px 4px 4px;
	border: none;
	text-align: center;
	font-size: 16px;
	padding: 12px;
	width: 150px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 0px;
	font-family: "Calibri";
}
.buttoncancel {
	display: inline-block;
	border-radius: 4px 4px 4px 4px;
	border: none;
	text-align: center;
	font-size: 16px;
	padding: 12px;
	width: 125px;
	height: 18px;
	margin: 0px;
	font-family: "Calibri";	
	background-color: #c9c9c9;
	text-decoration: none;
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
<%!
	InsertBean insertBean = new InsertBean();
%>
	<link href="styles/headerstyles.css" rel="stylesheet" type="text/css">
<%
if (LoginBean.loggedInDoctor == true){
%>
	<div class="topnav" style = "margin-bottom: 20px">
		<ul>
			<li><img src = "logo.png" align= "center" height="70px" style= "margin-left: 70px; margin-top: 30px;"></li>
			<li style= "margin-left: 540px"><a href = "viewallpatients.jsp"> View All Patients</a></li>
			<li style= "margin-left: 50px; margin-top: 50px"><a href = "logout.jsp" class="buttonsignout"> Sign out</a></li>
		</ul>
	</div>
	<center>
		<%
			if (insertBean.insertPatient(request)) {
				out.println("Success");
			}
		%>
	<form action="addpatient.jsp" method="get">	
	
	<h2>Add New Patient</h2>
	<br>
	</center>
	<aside>
	<div style="width = 100%">
		<center>
		
			<table>
				<tr><th>Full Name</th><td><input type="text" name="name" placeholder="Patient's full name"> </td></tr>
				<tr><th>Username</th><td><input type="text" name="username" placeholder="Patient's username"> </td></tr>
				<tr><th>Password</th><td><input type="password" name="password"> </td></tr>
				<tr><th>Date of Birth</th><td><input type="text" name="dob" placeholder="DD/MM/YYYY"> </td></tr>
				<tr><th>Gender</th><td><input type="text" name="gender" placeholder="Gender"> </td></tr>
				<tr><th>Blood Group</th><td><input type="text" name="bloodgroup" placeholder="Blood Group"> </td></tr>
				<tr><th>Marital Status</th><td><input type="text" name="mstatus" placeholder="Marital Status"> </td></tr>
			</table>
			<br>
			<table>
				<tr><th colspan="2"><center>Contact info</center></td></tr>
				<tr><th>Address</th><td><input type="text" name="address" placeholder="Address"> </td></tr>
				<tr><th>Email</th><td><input type="text" name="email" placeholder="Email Address"> </td></tr>
				<tr><th>Mobile Number</th><td><input type="text" name="mobile" placeholder="Mobile Number"></td></tr>
				<tr><th>Emergency Contact</th><td><input type="text" name="emobile" placeholder="Emergency Contact"> </td></tr>
			</table>
				
			<br>
	</div>
	</aside>
	<div class="rightwidget">
	<div style="width = 40%">
			<table>
					<tr><th colspan="2"><center>Medical Conditions</center></td></tr>
					<tr><th>Diabetes (if any)</th><td><input type="text" name="diabetes" placeholder="Diabetes (if any)"> </td></tr>
					<tr><th>Diseases</th><td> <textarea name='diseases' rows="6" cols="70"></textarea></td></tr>
					<tr><th>Allergies</th><td> <textarea name='allergies' rows="6" cols="70"></textarea></td></tr>
					<tr><th>Familial Diseases</th><td> <textarea name='fdiseases' rows="6" cols="70"></textarea></td></tr>
			</table>
			<br>
			<table>
					<tr><td colspan = "2"><center><input type="submit" value="Save Changes" class="button"></center></td></tr>
					<tr><td colspan = "2"><center><a href = "viewallpatients.jsp" class="buttoncancel">Cancel</a></center></td></tr>
			</table>
	</div>
	</div>
	</form>
</center>
<br>
<br>	
<%
} else
	response.sendRedirect("signin.jsp");
%>
</body>
</html>