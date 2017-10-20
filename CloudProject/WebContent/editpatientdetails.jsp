<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cmp494rest.NetClientGet"%>
<%@ page import="com.cmp494rest.SQLDatabaseConnection"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.cmp494rest.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<script>
	function toggleNewVisit() {
			var x = document.getElementById('addVisit');
			if (x.style.display === 'none') {
				x.style.display = 'block';
			} else {
				x.style.display = 'none';
			}
	}
	function toggleUploadImage() {
				var x = document.getElementById('addImage');
				if (x.style.display === 'none') {
					x.style.display = 'block';
				} else {
					x.style.display = 'none';
				}
	}
	function toggleUploadLab() {
				var x = document.getElementById('addLab');
				if (x.style.display === 'none') {
					x.style.display = 'block';
				} else {
					x.style.display = 'none';
				}
	}
</script>
</head>
<body>
<%! int pid;
	InsertBean insertBean = new InsertBean();
	String saveFile = new String();
	UpdateBean updateBean = new UpdateBean();
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

<aside>
		<center>
		<%
		if (request.getParameter("pid")!= null){
			pid = Integer.parseInt(request.getParameter("pid"));
			Patient.tempPID = pid;
		}
		else
			pid = Patient.tempPID;
		if (updateBean.updatePatient(request, pid)) 
			out.println("Patient's details updated successfully");
		%>
		
		<%! 
			
			String url_str;
			Patient patient;
			NetClientGet netc = new NetClientGet();
			
		%>
		<%
		url_str = "http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getPatientByID/" + pid;
		patient = netc.DispOnePatient(url_str);
		%>
		<h2><% out.print(patient.name); %></h2>
		<i><% out.print("ID# " + pid); %></i>
		<br>
		<br>
		<form action="editpatientdetails.jsp" method="get">
			<table>
				<tr><th style="text-align: right;">Full Name</th><td><input type="text" name="name" value = "<% out.print(patient.name); %>"> </td></tr>
				<tr><th style="text-align: right;">Date of Birth</th><td><input type="text" name="dob" value = "<% out.print(patient.DOB); %>"> </td></tr>
				<tr><th style="text-align: right;">Gender</th><td><input type="text" name="gender" value = "<% out.print(patient.gender); %>"> </td></tr>
				<tr><th style="text-align: right;">LMP</th><td><input type="text" name="lmp" value = "<% out.print(patient.LMP); %>"> </td></tr>
				<tr><th style="text-align: right;">Blood Group</th><td><input type="text" name="bloodgroup" value = "<% out.print(patient.bloodGroup); %>"> </td></tr>
				<tr><th style="text-align: right;">Marital Status</th><td><input type="text" name="mstatus" value = "<% out.print(patient.Marital_Status); %>"> </td></tr>
			</table>
			<br>
			<table>
				<tr><th colspan="2"><center>Contact info</center></td></tr>
				<tr><th style="text-align: right;">Email</th><td><input type="text" name="email" value = "<% out.print(patient.email); %>"> </td></tr>
				<tr><th style="text-align: right;">Mobile Number</th><td><input type="text" name="mobile" value = "<% out.print(patient.phonenum); %>"></td></tr>
				<tr><th style="text-align: right;">Emergency Contact</th><td><input type="text" name="emobile" value = "<% out.print(patient.emergency_contact); %>"> </td></tr>
			</table>
			<br>
			<table>
				<tr><th colspan="2"><center>Medical Conditions</center></th></tr>
				<tr><th style="text-align: right;">Diseases</th><td> <textarea name='diseases' rows="6" cols="70"><% out.print(patient.diseases); %></textarea></td></tr>
				<tr><th style="text-align: right;">Allergies</th><td> <textarea name='allergies' rows="6" cols="70"><% out.print(patient.allergies); %></textarea></td></tr>
				<tr><th style="text-align: right;">Familial Diseases</th><td> <textarea name='fdiseases' rows="6" cols="70"><% out.print(patient.familial_diseases); %></textarea></td></tr>
				<tr><td colspan = "2"><center><input type="submit" value="Save Changes" class="button"></center></td></tr>
			</table>
		</form>		
		<br>
	</center>
</aside>


<div class="rightwidget">
<center>
	<%

	if (insertBean.insertVitalSigns(request, pid)) 
				out.println("Vital signs added successfully");
	if (insertBean.insertPhysical(request, pid)) 
				out.println("Physical examination added successfully");
	if (insertBean.insertVisits(request, pid)) 
				out.println("Visit added successfully");	
	if (insertBean.insertMedication(request, pid, LoginBean.userID)) 
				out.println("Medication added successfully");	
	if (insertBean.insertImage(request, pid)) 
		out.println("Image uploaded successfully");	
	if (insertBean.insertReport(request, pid)) 
		out.println("Report uploaded successfully");	
	%>
</center>
	<center>	
		<br>
		<br>
		
		<!-- Vital Signs -->
		<form action="editpatientdetails.jsp" method="get">
			<table>
				<tr style="background-color: #68ccbf; color: white"><th colspan="6"><center>Vital Signs <input type="submit" value="Save" class="button" style = "width: 70px; float: right; margin-right: 35px; padding: 0px"></center></th></tr>
				<tr><td>Date</td><td>Blood Pressure</td><td>Pulse Rate</td><td>Respiration</td><td>Body Temp.</td></tr>
				<% 
				String output6 = netc.getVitals("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getVitalsByPatientId/" + pid);
				if( !output6.equals(null) || !output6.equals(""))
				{
					out.print(output6);
				}%>
				<tr>
					<td><input type="text" name="vdate" placeholder="Date"></td>
					<td><input type="text" name="pressure" placeholder="Blood Pressure"></td>
					<td><input type="text" name="rate" placeholder="Pulse Rate"></td>
					<td><input type="text" name="resp" placeholder="Respiration"></td>
					<td><input type="text" name="temp" placeholder="Body temp."></td>
				</tr>
			</table>
		</form>
		<br>
		</form>
		
		<!-- Physical Examination -->
		<br>
		<form action="editpatientdetails.jsp" method="get">
			<table>
				<tr style="background-color: #68ccbf; color: white"><th colspan="6"><center>Physical Examination <input type="submit" value="Save" class="button" style = "width: 70px; float: right; margin-right: 35px; padding: 0px"></center></th></tr>
				<tr><td>Date</td><td>Weight</td><td>Height</td></tr>
				<% 
				String output5 = netc.getPhysicalExam("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getExaminationByPatientId/" + pid);
				if( !output5.equals(null) || !output5.equals(""))
				{
					out.print(output5);
				}%>
				<tr>
					<td><input type="text" name="pdate" placeholder="dd/mm/yyyy"></td>
					<td><input type="text" name="weight" placeholder="Weight"></td>
					<td><input type="text" name="height" placeholder="Height"></td>
				</tr>
			</table>
		</form>
		<br>

		<!-- Visits -->
		<br>
		<form action="editpatientdetails.jsp" method="get">
			<table>
				<tr style="background-color: #68ccbf; color: white"><th colspan="6"><center>Visits <img src="images/plus.png" width="20px" align="center" style="float: right; margin-right: 35px" onclick="toggleNewVisit()"></center></th></tr>
				<tr><th>Date</th><th>Description</th><th>Symptoms</th><th>Treatment</th></tr>
				<% 
				String output4 = netc.getVisits("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getVisitsByPatientId/" + pid);
				if( !output4.equals(null) || !output4.equals(""))
				{
					out.print(output4);
				}%>

			</table>
			<div id ="addVisit" style= "display: none;">
				<table style="background-color: #cef7ff; font-family: 'Calibri'; font-size: medium; color: #717171; width: 60%; border-radius: 5px 5px 5px 5px; margin-top:30px;">
					<tr><th colspan = "2"><center>Add Visit</center></th></tr>
					<tr><th>Date</th><td><input type="text" name="vidate" placeholder="dd/mm/yyyy"> </td></tr>
					<tr><th>Treatment</th><td> <textarea name='vtreatment'cols="70"></textarea></td></tr>
					<tr><th>Description</th><td> <textarea name='vnotes'cols="70"></textarea></td></tr>
					<tr><th>Symptoms</th><td> <textarea name='vsymptoms'cols="70"></textarea></td></tr>
					<tr>
						<td colspan = "2">
							<center>
								<input type="submit" value="Save Changes" class="button"></input> 
								<br><br> 
								<a style="margin-left: 0px;" onclick="toggleNewVisit()"> Cancel </a> 
							</center>
						</td>
					</tr>
				</table>
			</div>
		</form>
		<br>
		
		<!-- Medications -->
		<br>
		<form action="editpatientdetails.jsp" method="get">
			<table>
				<tr style="background-color: #68ccbf; color: white"><th colspan="6"><center>Medication <input type="submit" value="Save" class="button" style = "width: 70px; float: right; margin-right: 35px; padding: 0px"></center></th></tr>
				<tr><th>Start Date</th><th>End Date</th><th>Name</th><th>Dose</th><th>Notes</th></tr>
				<tr><td>Start Date</td><td>End Date</td><td>Name</td><td>Dose</td><td>Notes</td></tr>
				<% 
				String output3 = netc.DispMedication("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getPerscribed_MedicationByPatientId/" + pid);
				if( !output3.equals(null) || !output3.equals(""))
				{
					out.print(output3);
				}%>		
				<tr>
					<td><input type="text" name="startdate" placeholder="dd/mm/yyyy"></td>
					<td><input type="text" name="enddate" placeholder="dd/mm/yyyy"></td>
					<td><input type="text" name="medname" placeholder="Name"></td>
					<td><input type="text" name="dose" placeholder="Dose"></td>
					<td><input type="text" name="mednotes" placeholder="Notes"></td>
				</tr>
			</table>
		</form>
		<br>
		
		<!-- Imaging Reports -->
		<br>
		<form>
			<table>
				<tr style="background-color: #68ccbf; color: white"><th colspan="6"><center>Imaging Reports <img src="images/plus.png" width="20px" align="center" style="float: right; margin-right: 35px" onclick="toggleUploadImage()"></center></th></tr>
				<tr><th>Date</th><th>Img. ID.</th><th>File</th><th>Type</th><th>Notes</th></tr>
				<% 
				String output = netc.getImage("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getImageById/" + pid);
				if( !output.equals(null) || !output.equals(""))
				{
					out.print(output);
				}%>
			</table>
			</form>
						
			<%
				
				String contentType = request.getContentType();
				
				if ((contentType != null) && (contentType.indexOf("multipart/form-data")>=0)){
						
					DataInputStream in = new DataInputStream(request.getInputStream());
					
					int formDataLength = request.getContentLength();
					byte dataBytes[] = new byte[formDataLength];
					int byteRead = 0;
					int totalBytesRead = 0;
					
					while (totalBytesRead < formDataLength){
						byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
						totalBytesRead += byteRead;
					}
					
					String file = new String(dataBytes);
					
					saveFile = file.substring(file.indexOf("filename=\"")+ 10);
					saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
					saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
					
					int lastIndex = contentType.lastIndexOf("=");
					
					String boundary = contentType.substring(lastIndex + 1, contentType.length());
					
					int pos;
					
					pos = file.indexOf("filename=\"");
					pos = file.indexOf("\n", pos) + 1;
					pos = file.indexOf("\n", pos) + 1;
					pos = file.indexOf("\n", pos) + 1;
					
					int boundaryLocation = file.indexOf(boundary, pos) - 4;
					
					int startPos = ((file.substring(0, pos)).getBytes()).length;
					int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
					
					InsertBean.imageFile = saveFile;
					InsertBean.imagePath = "D:\\home\\imagefiles\\"+saveFile;
					//saveFile = "C:/uploadedfiles/" + saveFile;
					saveFile = "D:/home/imagefiles/" + saveFile;
					
					
					InsertBean.uploaded = true;
					
					File ff = new File(saveFile);
					
					try{
						
						FileOutputStream fileOut = new FileOutputStream(ff);
						fileOut.write(dataBytes, startPos, (endPos - startPos));
						fileOut.flush();
						fileOut.close();
					} catch (Exception e){
						out.println(e);
					}
				
				}
			
			%>
			
			<div id ="addImage" style= "display: none;">
			<form action="editpatientdetails.jsp" method="post" enctype="multipart/form-data">		
				<table style="background-color: #cef7ff; font-family: 'Calibri'; font-size: medium; color: #717171; width: 60%; border-radius: 5px 5px 5px 5px; margin-top:30px;">
					<tr><th colspan = "2"><center>1. Upload Report</center></th></tr>
					<tr><th>File</th><td><input type="file" style="margin-left: 0px" name="ifile"></td></tr>
					<tr><td colspan = "2"><center><input type="submit" value="Upload" class="button"></input> <br><br> <a style="margin-left: 0px;" onclick="toggleUploadImage()"> Cancel </a> </center></td></tr>
					</table>
					<br>
					</form>
			<form action="editpatientdetails.jsp" method="get">
				<table style="background-color: #cef7ff; font-family: 'Calibri'; font-size: medium; color: #717171; width: 60%; border-radius: 5px 5px 5px 5px; margin-top:30px;">
					<tr><th colspan = "2"><center>2. Upload Details</center></th></tr>
					<tr><th>Date</th><td><input type="text" name="idate" placeholder="Date"> </td></tr>
					<tr><th>Image ID.</th><td><input type="text" name="imageid" placeholder="Image. ID."></td></tr>
					<tr><th>File</th>
					<td>
						<% out.print(InsertBean.imageFile); %>
					</td>
					</tr>
					<tr><th>Type</th><td><input type="text" name="itype" placeholder="Image Type"></td></tr>
					<tr><th>Notes</th><td> <textarea name='inotes' rows="6" cols="70"></textarea></td></tr>
					<tr><td colspan = "2"><center><input type="submit" value="Save Changes" class="button"></input> <br><br> <a style="margin-left: 0px;" onclick="toggleUploadImage()"> Cancel </a> </center></td></tr>
				</table>
				</form>
			</div>
			
		<br>
		
		<!-- Lab Reports -->
		<br>
		<form>
			<table>
				<tr style="background-color: #68ccbf; color: white"><th colspan="6"><center>Lab Reports <img src="images/plus.png" width="20px" align="center" style="float: right; margin-right: 45px" onclick="toggleUploadLab()"></center></th></tr>
				<tr><th>Date</th><th>Report. ID.</th><th>File</th><th>Notes</th></tr>
				<%
				String output2 = netc.DispLabTest("http://cloudehr.azurewebsites.net/WebServices/rest/EHR/getTestByPatientId/" + pid);
				if( !output2.equals(null) || !output2.equals(""))
				{
					out.print(output2);
				}%>
				
			</table>
			</form>
				
			<div id ="addLab" style= "display: none;">
			<form action="editpatientdetails.jsp" method="post" enctype="multipart/form-data">		
				<table style="background-color: #cef7ff; font-family: 'Calibri'; font-size: medium; color: #717171; width: 60%; border-radius: 5px 5px 5px 5px; margin-top:30px;">
					<tr><th colspan = "2"><center>1. Upload Report</center></th></tr>
					<tr><th>File</th><td><input type="file" style="margin-left: 0px" name="ifile"></td></tr>
					<tr><td colspan = "2"><center><input type="submit" value="Upload" class="button"></input> <br><br> <a style="margin-left: 0px;" onclick="toggleUploadImage()"> Cancel </a> </center></td></tr>
					</table>
					<br>
					</form>
			<form action="editpatientdetails.jsp" method="get">
				<table style="background-color: #cef7ff; font-family: 'Calibri'; font-size: medium; color: #717171; width: 60%; border-radius: 5px 5px 5px 5px; margin-top:30px;">
					<tr><th colspan = "2"><center>2. Upload Details</center></th></tr>
					<tr><th>Date</th><td><input type="text" name="rdate" placeholder="Date"> </td></tr>
					<tr><th>Report ID.</th><td><input type="text" name="reportid" placeholder="Report ID."></td></tr>
					<tr><th>File</th>
					<td>
						<% out.print(InsertBean.imageFile); %>
					</td>
					</tr>
					<tr><th>Notes</th><td> <textarea name='rnotes' rows="6" cols="70"></textarea></td></tr>
					<tr><td colspan = "2"><center><input type="submit" value="Save Changes" class="button"></input> <br><br> <a style="margin-left: 0px;" onclick="toggleUploadImage()"> Cancel </a> </center></td></tr>
				</table>
			</form>
			</div>
			
		
		<br>
		
	</center>
</div>
<%
} else
	response.sendRedirect("signin.jsp");
%>
</body>
</html>