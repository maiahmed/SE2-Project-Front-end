package com.application;



import java.util.HashMap;
import java.util.Map;

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
public class PlaceServicesController {

	@Context
	HttpServletRequest request;
	@GET
	@Path("/AddPlace")
	@Produces(MediaType.TEXT_HTML)
	public Response Place() {
		return Response.ok(new Viewable("/Place.jsp")).build();
	} 
	@GET
	@Path("/CheckIn")
	@Produces(MediaType.TEXT_HTML)
	public Response CheckIn() {
		return Response.ok(new Viewable("/checkin.jsp")).build();
	}
	
	@GET
	@Path("/showLocation")
	@Produces(MediaType.TEXT_HTML)
	public Response showLocationPage() {
		return Response.ok(new Viewable("/ShowLocation.jsp")).build();
	}
	
	@GET
	@Path("/LastPositionForm")
	@Produces(MediaType.TEXT_HTML)
	public Response showForm() {
		return Response.ok(new Viewable("/LastPositionForm.jsp")).build();
	}

	@POST
	@Path("/updateMyLocation")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateLocation(@FormParam("lat") String lat,
			@FormParam("long") String lon) {
		HttpSession session = request.getSession();
		Long id = (Long) session.getAttribute("id");
		String serviceUrl = "http://localhost:8080/FCISquare/rest/updatePosition";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/updatePosition";
		String urlParameters = "id=" + id + "&lat=" + lat + "&long=" + lon;
		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		JSONObject obj;
		try {
			obj = (JSONObject) parser.parse(retJson);
			Long status = (Long) obj.get("status");
			if (status == 1)
				return "Your location is updated";
			else
				return "A problem occured";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "A problem occured";

	}

	@GET
	@Path("/SavePlace")
	@Produces(MediaType.TEXT_HTML)
	public Response SavePlace() {
		return Response.ok(new Viewable("/SavePlace.jsp")).build();
	}
	
	@POST
	@Path("/doGetplace")
	@Produces(MediaType.TEXT_HTML)
	public Response Getplace() {

		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id");
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/GetLastPostion";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/GetLastPostion";

		String urlParameters = "id=" + id;
		;

		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retJson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		System.out.println(retJson);
		HttpSession session = request.getSession();
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject) parser.parse(retJson);
			session.setAttribute("email", obj.get("email"));

			session.setAttribute("name", obj.get("name"));

			session.setAttribute("id", obj.get("id"));

			session.setAttribute("lat", obj.get("lat"));

			session.setAttribute("lang", obj.get("lang"));
			session.setAttribute("pass", obj.get("pass"));

			Map<String, Double> map = new HashMap<String, Double>();

			map.put("lat", (double) obj.get("lat"));
			map.put("lang", (double) obj.get("lang"));

			return Response.ok(new Viewable("/LastPostion.jsp", map)).build();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	}
	
	@POST
	@Path("/doAddPlace")
	@Produces(MediaType.TEXT_HTML)
	public void addplace(@FormParam("name") String name,
			@FormParam("description") String description, @FormParam("lat") String lat,@FormParam("long") String lang) {
		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id"); 
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/AddNewPlace";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/AddNewPlace";

		String urlParameters = "name=" + name + "&description=" + description + "&lat="
				+ lat+"&long="+lang+"&id="+id;
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println("json"+retJson);
		/*HttpSession session = request.getSession();
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
		return null;*/

	} 
	@POST
	@Path("/doCheckIn")
	@Produces(MediaType.TEXT_HTML)
	public Response checkin1(@FormParam("name") String name) {
		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id"); 
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/CheckIn";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/CheckIn";
		
		String urlParameters = "name=" + name + "&id=" +id;
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retJson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		System.out.println("json"+retJson);
		Map<String, String> map = new HashMap<String, String>();
		map.put("val", retJson);
		return Response.ok(new Viewable("/check_in_result.jsp", map)).build();
		}	
	}
	
	@POST
	@Path("/doSavePlace")
	@Produces(MediaType.TEXT_HTML)
	public void Saveplace(@FormParam("placeid") String placeid) {
		System.out.println(placeid);
		HttpSession session1 = request.getSession();
		long  id =  (long)session1.getAttribute("id");
		System.out.println(id);
		String serviceUrl = "http://localhost:8080/FCISquare/rest/SavePlace";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/SavePlace";

		String urlParameters = "placeid=" + placeid + "&id=" + id;
		System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println("json" + retJson);
		

	}

	
	
} 
