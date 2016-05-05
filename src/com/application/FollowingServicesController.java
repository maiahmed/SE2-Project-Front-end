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

public class FollowingServicesController {
	
	@Context
	HttpServletRequest request;
	
	@GET
	@Path("/Follow")
	@Produces(MediaType.TEXT_HTML)
	public Response followUser() {
		return Response.ok(new Viewable("/Follow.jsp")).build();
	}
	
	@GET
	@Path("/Unfollow")
	@Produces(MediaType.TEXT_HTML)
	public Response unfollowUser() {
		return Response.ok(new Viewable("/unfollow.jsp")).build();
	}
	@GET
	@Path("/getfollows")
	@Produces(MediaType.TEXT_HTML)
	public Response getfollows() {
		return Response.ok(new Viewable("/getfollowers.jsp")).build();
	}

	@POST
	@Path("/doUnfollow")
	@Produces(MediaType.TEXT_HTML)
	public void unfollow(@FormParam("idUnfollow") String idUnfollow) {

		System.out.println("hjgdfh" + idUnfollow);

		HttpSession session = request.getSession();
		Long id = (Long) session.getAttribute("id");
		System.out.println(id);
		
		String serviceUrl = "http://localhost:8080/FCISquare/rest/unFollow";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/unFollow";

		String urlParameters = "idFollower1=" + id + "&idFollower2="
				+ Integer.parseInt(idUnfollow);

		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println(retJson);
		HttpSession session1 = request.getSession();
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

			// return Response.ok(new Viewable("/home.jsp", map)).build();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/doGetfollowers")
	@Produces(MediaType.TEXT_HTML)
	public Response GetFollowers() {

		HttpSession session1 = request.getSession();
		Long id = (Long) session1.getAttribute("id");
		System.out.println(id);
		
		String serviceUrl = "http://localhost:8080/FCISquare/rest/GetFollowers";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/GetFollowers";

		String urlParameters = "idFollower1=" + id;
		;

		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8"); 
		if (retJson == null) {
			return Response.ok(new Viewable("/error.jsp")).build();

		} 
		else {
		System.out.println(retJson);
		Map<String, String> map = new HashMap<String, String>();
		map.put("val", retJson);
		return Response.ok(new Viewable("/Followers.jsp", map)).build();

	}
	}
	@POST
	@Path("/doFollow")
	@Produces(MediaType.TEXT_HTML)
	public void follow(@FormParam("idFollow") String idFollow) {

		System.out.println("hjgdfh" + idFollow);

		HttpSession session = request.getSession();
		Long id = (Long) session.getAttribute("id");
		System.out.println(id);
		
		String serviceUrl = "http://localhost:8080/FCISquare/rest/Follow";
//		String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/Follow";

		String urlParameters = "idFollower1=" + id + "&idFollower2="
				+ Integer.parseInt(idFollow);

		// System.out.println(urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		System.out.println(retJson);
		// HttpSession session1 = request.getSession();
		// JSONObject obj = new JSONObject();
		// JSONParser parser = new JSONParser();
		/**
		 * obj = (JSONObject) parser.parse(retJson);
		 * session.setAttribute("email", obj.get("email"));
		 * session.setAttribute("name", obj.get("name"));
		 * session.setAttribute("id", obj.get("id"));
		 * session.setAttribute("lat", obj.get("lat"));
		 * session.setAttribute("long", obj.get("long"));
		 * session.setAttribute("pass", obj.get("pass"));
		 **/
		/**
		 * Map<String, String> map = new HashMap<String, String>();
		 * 
		 * map.put("name", (String) obj.get("name")); map.put("email", (String)
		 * obj.get("email"));
		 */

		// return Response.ok(new Viewable("/home.jsp", map)).build();
	}
}
