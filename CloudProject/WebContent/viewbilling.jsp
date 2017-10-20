<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cmp494rest.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Billing </title>
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
	width: 65%;
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

<%!String url_str = "http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getBillById/" + LoginBean.userID;;
	NetClientGet netc = new NetClientGet();%>
<%
if (LoginBean.loggedInPatient == true){
%>
<div class="topnav" style = "margin-bottom: 40px">
	<ul>
		<li><img src = "logopatient.png" align= "center" height="70px" style= "margin-left: 70px; margin-top: 30px;"></li>
		<li style= "margin-left: 300px"><a href = "viewpatientdetails.jsp"> View Patient Details </a></li>
		<li><a href = "viewbilling.jsp"> View Billing Details </a></li>
		<li><a href = "viewguardians.jsp"> View Guardians </a></li>
		<li style= "margin-left: 50px; margin-top: 50px"><a href = "logout.jsp" class="buttonsignout"> Sign out</a></li>
	</ul>
</div>
	
<center>
<h2>Billing Information</h2>
<br>
</center>

	<center>
		<table>
			<tr><th>Date</th><th>Bill ID</th><th>Item/Service</th><th>Total</th><th>Status</th></tr>
			<% out.print(netc.getBills(url_str)); %>
		</table>
			
		<br>
	</center>
<%
} else
	response.sendRedirect("signinpatient.jsp");
%>
</body>
</html>