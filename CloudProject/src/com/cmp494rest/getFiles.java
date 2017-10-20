package com.cmp494rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/images")
public class getFiles {
@GET
@Path("{param}/{aparam}")
public String getMsg(@PathParam("param") String msg, @PathParam("aparam") String msg2) {
String output = "My Method Says : " + msg+" another "+msg2;
	
	
	return output;
 }
}