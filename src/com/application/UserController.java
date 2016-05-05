package com.application;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe

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
<<<<<<< HEAD
import org.json.simple.JSONArray;
=======
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/")
public class UserController {

	@Context
	HttpServletRequest request;

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public Response loginPage() {
		return Response.ok(new Viewable("/Login.jsp")).build();
	}

	@GET
	@Path("/signUp")
	@Produces(MediaType.TEXT_HTML)
	public Response signUpPage() {
		return Response.ok(new Viewable("/Signup.jsp")).build();
<<<<<<< HEAD
	} 
	@GET
	@Path("/mypage")
	@Produces(MediaType.TEXT_HTML)
	public Response showPage() {
		return Response.ok(new Viewable("/Firsthome.jsp")).build();
	}
	@GET
	@Path("/mynotifications")
	@Produces(MediaType.TEXT_HTML)
	public Response NotifyMe() {
		return Response.ok(new Viewable("/GetNotifications.jsp")).build();
	}
	@POST
	@Path("/showCheckin")
	@Produces(MediaType.TEXT_HTML) 
	public Response show(@FormParam("id") String value ){
		System.out.println(value);  
		String serviceUrl = "http://localhost:8080/FCISquare/rest/showcheckin";
//		 String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/showcheckin";

		String urlParameters = "ID=" + value;
		// System.out.println(urlParameters);
		String retjson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");  
		if (retjson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		System.out.println(retjson); 
		String split_string_array[] = retjson.split(",");
		for (int i = 0; i < split_string_array.length; i++) {
			System.out.println(split_string_array[i]);
		}
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < split_string_array.length; i++)
			v.add(split_string_array[i]);  
		ArrayList<String> map=new ArrayList<String>(); 
		//String map[]=new String[v.size()];
		for(int i=0;i<v.size();i++)  
			map.add(v.get(i)); 
		return Response.ok(new Viewable("/CheckInPage.jsp", map)).build();
		
		
	}}
	@POST
	@Path("/doGetNotification")
	@Produces(MediaType.TEXT_HTML) 
	public Response doGetNotification( ){
		String serviceUrl = "http://localhost:8080/FCISquare/rest/getNotification";
//		 String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/getNotification";
		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id");
		System.out.println(id);
		String urlParameters = "ID=" + id;
		// System.out.println(urlParameters);
		String retjson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");  
		if (retjson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		System.out.println(retjson);
		String split_string_array[] = retjson.split(",");
		for (int i = 0; i < split_string_array.length; i++) {
			System.out.println(split_string_array[i]);
		}
		Vector<String> res = new Vector<String>();
		for (int i = 0; i < split_string_array.length; i++)
			res.add(split_string_array[i]);
		
		System.out.println(res.toString());
		//return res; 
		
		return Response.ok(new Viewable("/Notifications.jsp", res)).build();
		}
		
	}
	@POST
	@Path("/doGetCheckIn")
	@Produces(MediaType.TEXT_HTML)
	public Response showHomePage(@FormParam("Id") String value) {
		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id");
		System.out.println(id);
		System.out.println("heeeeee");
		String serviceUrl = "http://localhost:8080/FCISquare/rest/getcheckins";
//		 String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/getcheckins";

		String urlParameters = "ID=" + id;
		// System.out.println(urlParameters);
		String retjson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retjson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		System.out.println(retjson);
		
		String split_string_array[] = retjson.split(",");
		for (int i = 0; i < split_string_array.length; i++) {
			System.out.println(split_string_array[i]);
		}
		Vector<String> res = new Vector<String>();
		for (int i = 0; i < split_string_array.length; i++)
			res.add(split_string_array[i]);
		if (Integer.parseInt(value) == 1) {
			converter c = new converter(new DateStrategy());
			System.out.println(" REsult :");
			System.out.println(c.executeStrategy(res)); 
			Vector<String>v=c.executeStrategy(res);
			//Map<String, String> map = new HashMap<String, String>();  
			ArrayList<String> map=new ArrayList<String>(); 
			//String map[]=new String[v.size()];
			for(int i=0;i<v.size();i++)  
				map.add(v.get(i));  
				//map[i]=v.get(i);
		//	System.out.println(map[i]);
			return Response.ok(new Viewable("/MyHome.jsp", map)).build();
		} else if (Integer.parseInt(value) == 2) {
			
			converter c = new converter(new Nearst_PlacesStrategies());
			System.out.println(" REsult :");
			//System.out.println(c.executeStrategy(res)); 
			Vector<String>v=c.executeStrategy(res);
			ArrayList<String> map=new ArrayList<String>(); 
			//String map[]=new String[v.size()];
			for(int i=0;i<v.size();i++)  
				map.add(v.get(i));  
				//map[i]=v.get(i);
		//	System.out.println(map[i]);
			return Response.ok(new Viewable("/MyHome.jsp", map)).build();
		}
		return null;

	} }


=======
	}
	
	@GET
	@Path("/showLocation")
	@Produces(MediaType.TEXT_HTML)
	public Response showLocationPage(){
		return Response.ok(new Viewable("/ShowLocation.jsp")).build();
	}

	@POST
	@Path("/updateMyLocation")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateLocation(@FormParam("lat") String lat, @FormParam("long") String lon){
		HttpSession session = request.getSession();
		Long id = (Long) session.getAttribute("id");
		//String serviceUrl = "http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/updatePosition";
		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/login";

		String urlParameters = "id=" + id + "&lat=" + lat + "&long="+ lon;
		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		JSONObject obj;
		try {
			obj = (JSONObject)parser.parse(retJson);
			Long status = (Long) obj.get("status");
			if(status == 1)
				return "Your location is updated";
			else
				return "A problem occured";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "A problem occured";
		
	}
	@POST 
	@Path("/doLogin")
	@Produces(MediaType.TEXT_HTML) 
	public Response FollowPage(@FormParam("email") String email,
			@FormParam("pass") String pass) {
		//String serviceUrl = "http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/login";
		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/login";

		String urlParameters = "email=" + email + "&pass=" + pass;
		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		HttpSession session = request.getSession();
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject) parser.parse(retJson);
			session.setAttribute("email", obj.get("email"));
			session.setAttribute("name", obj.get("name"));
			session.setAttribute("id", obj.get("id"));
			session.setAttribute("lat", obj.get("lat"));
			session.setAttribute("long", obj.get("long"));
			session.setAttribute("pass", obj.get("pass"));
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", (String) obj.get("name"));
			map.put("email", (String) obj.get("email"));

			return Response.ok(new Viewable("/home.jsp", map)).build();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
	@POST
	@Path("/doLogin")
	@Produces(MediaType.TEXT_HTML)
	public Response showHomePage(@FormParam("email") String email,
			@FormParam("pass") String pass) {
<<<<<<< HEAD

		System.out.println("heeeeee");
		String serviceUrl = "http://localhost:8080/FCISquare/rest/login";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/login";
=======
		//String serviceUrl = "http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/login";
		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/login";
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe

		String urlParameters = "email=" + email + "&pass=" + pass;
		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
<<<<<<< HEAD
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retJson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		HttpSession session = request.getSession(); 
		System.out.println("heeere");
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		System.out.println(retJson);
		try {
			obj = (JSONObject) parser.parse(retJson);
			
=======
				"application/x-www-form-urlencoded;charset=UTF-8");
		HttpSession session = request.getSession();
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject) parser.parse(retJson);
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
			session.setAttribute("email", obj.get("email"));
			session.setAttribute("name", obj.get("name"));
			session.setAttribute("id", obj.get("id"));
			session.setAttribute("lat", obj.get("lat"));
			session.setAttribute("long", obj.get("long"));
			session.setAttribute("pass", obj.get("pass"));
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", (String) obj.get("name"));
			map.put("email", (String) obj.get("email"));

			return Response.ok(new Viewable("/home.jsp", map)).build();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
<<<<<<< HEAD
	}
	}
=======

	}

>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
	@POST
	@Path("/doSignUp")
	@Produces(MediaType.TEXT_HTML)
	public Response showHomePage(@FormParam("name") String name,
			@FormParam("email") String email, @FormParam("pass") String pass) {
<<<<<<< HEAD
		String serviceUrl = "http://localhost:8080/FCISquare/rest/signup";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/signup";
=======
		//String serviceUrl = "http://se2firstapp-softwareeng2.rhcloud.com/FCISquare/rest/signup";
		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/signup";
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe

		String urlParameters = "name=" + name + "&email=" + email + "&pass="
				+ pass;
		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
<<<<<<< HEAD
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retJson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
=======
				"application/x-www-form-urlencoded;charset=UTF-8");
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
		HttpSession session = request.getSession();
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject) parser.parse(retJson);
			session.setAttribute("email", obj.get("email"));
			session.setAttribute("name", obj.get("name"));
			session.setAttribute("id", obj.get("id"));
			session.setAttribute("lat", obj.get("lat"));
			session.setAttribute("long", obj.get("long"));
			session.setAttribute("pass", obj.get("pass"));
			Map<String, String> map = new HashMap<String, String>();

			map.put("name", (String) obj.get("name"));
			map.put("email", (String) obj.get("email"));

			return Response.ok(new Viewable("/home.jsp", map)).build();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

<<<<<<< HEAD
	}}
=======
	}
>>>>>>> 3a7cab454d0e0e3232dcf96c9454550fd7c1acbe
}
