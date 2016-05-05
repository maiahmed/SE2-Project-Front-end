package com.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

public class LikeNotification implements NotificationList {
	@Context
	HttpServletRequest request;
    
	@Override
	public void notifay(int performerID, int notificationType, int checkInID) {
		// TODO Auto-generated method stub
	

			//System.out.println("hjgdfh" + idUnfollow);

			HttpSession session = request.getSession();
			Long id = (Long) session.getAttribute("id");
			System.out.println(id);
			
			String serviceUrl = "http://localhost:8080/FCISquare/rest/Notify";
//			String serviceUrl = "http://foursquare-softwarwproject.rhcloud.com/FCISquare/rest/Notify";

			String urlParameters = "performerID=" + performerID + "&notificationType="
					+ notificationType + "&checkInID=" +checkInID;

			// System.out.println(urlParameters);
			String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
					"application/x-www-form-urlencoded;charset=UTF-8");
			System.out.println(retJson);}
		
	}


