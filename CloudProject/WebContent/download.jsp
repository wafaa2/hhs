<%@ page import="com.cmp494rest.*"%>

<%    

  String filename = "MRI Sample.pdf";   
  String filepath = "D:\\home\\imagefiles\\";   
  
  response.setContentType("APPLICATION/OCTET-STREAM");
  NetClientGet netc = new NetClientGet();
  filepath = NetClientGet.getFilepath();
  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);  
            
  int i;   
  while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
  }   
  fileInputStream.close();   
%>   