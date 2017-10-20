<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cmp494rest.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Patients</title>
<style>
body {
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
tr:hover {
  background: #c6c6c6;
  color: black;
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
	width:400px;
    box-sizing: border-box;
    border: 0.5px solid #ccc;
    border-radius: 4px;
    border-style: solid solid solid solid;
    padding: 10px 10px 10px 10px;
	font-family: "Calibri";
	font-size: medium;
	color: black;
}
.button {
	display: inline-block;
	border-radius: 0px 5px 5px 0px;
	border: none;
	text-align: center;
	font-size: 16px;
	padding: 12px;
	width: 100px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 0px;
	color: #4f8e85;
	font-family: "Calibri";
}
.buttonnew {
	display: inline-block;
	border-radius: 4px 4px 4px 4px;
	border: none;
	text-align: center;
	font-size: 16px;
	padding: 12px;
	width: 150px;
	height: 18px;
	margin: 0px;
	color: white;
	font-family: "Calibri";	
	background-color: #68ccbf;
	text-decoration: none;
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
		<li><a href = "addguardian.jsp"> Add Guardian </a></li>
		<li style= "margin-left: 50px; margin-top: 50px"><a href = "logout.jsp" class="buttonsignout"> Sign out</a></li>
	</ul>
</div>

		<%! 	
			String url_str;
			NetClientGet netc = new NetClientGet();
		%>
		<%
		url_str = "http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getPatientGuardians/" + LoginBean.userID;
		%>

	<center>
		<div style = "width:70%">
				<a href = "addguardian.jsp" class="buttonnew"><img src="images/user.png" width="20px" align="center"> Add Guardian</a>
			<br>
			<br>
			<table>
				<tr><th>Full Name</th><th>Address</th><th>Phone Number</th><th>Email Address</th><th>Relationship to Patient</th></tr>
					<%		out.print(netc.DispGuardians(url_str)); %>			
			</table>
		</div>
	</center>
<%
} else
	response.sendRedirect("signinpatient.jsp");
%>
</body>
</html>