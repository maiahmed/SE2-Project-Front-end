package com.application;



import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/")

public class InteractionServicesController {
	
	@Context
	HttpServletRequest request;
	
	@GET
	@Path("/Like")
	@Produces(MediaType.TEXT_HTML)
	public Response like() {
		return Response.ok(new Viewable("/Like.jsp")).build();
	}
	
	@POST
	@Path("/doLike")
	@Produces(MediaType.TEXT_HTML)
	public void Like(@FormParam("CheckInId") String checkInId ) {
		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id"); 
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/Like";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/Like";
		
		String urlParameters = "userId=" + id + "&CheckInId=" +Integer.parseInt(checkInId);
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println("json"+retJson);
		//Map<String, String> map = new HashMap<String, String>();
		//map.put("val", retJson);
		//return Response.ok(new Viewable("Like.jsp", map)).build();
		
	}
	
	@GET
	@Path("/Comment")
	@Produces(MediaType.TEXT_HTML)
	public Response comment() {
		return Response.ok(new Viewable("/Comment.jsp")).build();
	}
	

	@POST
	@Path("/doComment")
	@Produces(MediaType.TEXT_HTML)
	public void Comment(@FormParam("CheckInId") String checkInId, @FormParam("CommentText") String text ) {
		HttpSession session1 = request.getSession();
		System.out.println(checkInId);
		System.out.println(text);
		Long id = (Long) session1.getAttribute("id"); 
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/Comment";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/Comment";
		
		String urlParameters = "userId=" + id + "&CheckInId=" +Integer.parseInt(checkInId) + "&CommentText=" +text;
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println("json"+retJson);
		
	} 
	//DeletePost 
	@POST
	@Path("/DeletePost")
	@Produces(MediaType.TEXT_HTML)
	public void Delete(@FormParam("id") String checkInId,@FormParam("type") String type) {
		HttpSession session1 = request.getSession();
		System.out.println("hereeeee"+type); 
		int t=0;
		if(type.equals("Like"))
		{   System.out.println("hereeeee");
			t = 1;
		}
		else if(type.equals( "Comment"))
		{
			t = 2;
		}
		else if(type.equals("Check"))
		{
			t = 3;
		}
		
		Long id = (Long) session1.getAttribute("id"); 
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/deleteHistory";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/deleteHistory";
		
		String urlParameters = "userId=" + id + "&type="+t+"&CheckID=" + checkInId;
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println("json"+retJson);
		
		
	}
	
	
	@POST
	@Path("/History")
	@Produces(MediaType.TEXT_HTML)
	public Response history() {
		HttpSession session1 = request.getSession();
		
		Long id = (Long) session1.getAttribute("id"); 
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/history";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/history";
		
		String urlParameters = "userId=" + id;
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retJson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} else {
		System.out.println("json"+retJson);
		
		String split_string_array[] = retJson.split(",");
		for (int i = 0; i < split_string_array.length; i++) {
			System.out.println(split_string_array[i]);
		}
		Vector<String> res = new Vector<String>();
		for (int i = 0; i < split_string_array.length; i++)
			res.add(split_string_array[i]);
		
		System.out.println(res.toString());
		//return res; 
		
		return Response.ok(new Viewable("/History.jsp", res)).build();
	}
	}

}
