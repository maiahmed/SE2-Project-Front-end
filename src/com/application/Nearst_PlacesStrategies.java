package com.application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import com.sun.javafx.collections.MappingChange.Map;

public class Nearst_PlacesStrategies implements Strategy {

	@Override
	
	public Vector<String> sort(Vector<String> v) {
		
		// TODO Auto-generated method stub
		double userlang = Double.parseDouble(v.get(0));
		double userlat = Double.parseDouble(v.get(1));
		
		
		//List<Entry<Double, String>> values = new ArrayList<>();
		//Entry<Double, String> pair;
		//HashMap hm = new HashMap();	
		HashMap<Double, String> hm = new HashMap<Double, String>();
		HashMap<Double, Integer> hm_id = new HashMap<Double, Integer>();

		//hm.put(1, new Point2D.Double(50, 50));
		
		for(int i=2;i<v.size();i+=4)
		{
			String checkInName = v.get(i);
			double lat = Double.parseDouble(v.get(i+1));
			double lang = Double.parseDouble(v.get(i+2));
			int id=Integer.parseInt(v.get(i+3));
			double distace = getDistanceFromLatLonInKm(userlat, userlang, lat, lang); 
			hm.put(distace, checkInName);
			hm_id.put(distace,id);
			
			
		}
		//sortHashMapByValues(hm);
		TreeMap<Double, String> treeMap = new TreeMap<Double, String>(hm);
		TreeMap<Double, Integer> treeMap_id = new TreeMap<Double,Integer>(hm_id);

//		for (Double str : ((HashMap<Double, String>) treeMap).keySet()) {
//		    System.out.println(str);
//		}
		Vector<String>checks = new Vector<String>();
		for (Entry<Double, String> entry : treeMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() 
                                      + " Value : " + entry.getValue());
			checks.add(entry.getValue());
		}
		Vector<Integer>ids = new Vector<Integer>();
		for (Entry<Double, Integer> entry : treeMap_id.entrySet()) {
			System.out.println("Key : " + entry.getKey() 
                                      + " Value : " + entry.getValue());
			ids.add(entry.getValue());
		}
		Vector<String>ans=new Vector<String>();
		for(int i=0;i<ids.size();i++)
		{
			ans.addElement(checks.get(i));
			ans.addElement(Integer.toString(ids.get(i)));
		}
		
		
		return ans;
	}
	

	private double getDistanceFromLatLonInKm(double lat1, double lon1,
			double lat2, double lon2) {
		double R = 6371; // Radius of the earth in km
		double dLat = deg2rad(lat2 - lat1); // deg2rad below
		double dLon = deg2rad(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		// double d = R * c; // Distance in km
		// return d;
		return c;
	}

	private double deg2rad(double deg) {
		return deg * (Math.PI / 180);
	}

	
	public static void printMap(HashMap<Double, String> hm) {
		for (Entry<Double, String> entry : ((HashMap<Double, String>) hm).entrySet()) {
			System.out.println("Key : " + entry.getKey() 
                                      + " Value : " + entry.getValue());
		}
	}
	
	public LinkedHashMap<String, Double> sortHashMapByValues(
	        HashMap<String, Double> passedMap) {
	    List<String> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Double> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<String, Double> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Double> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Double val = valueIt.next();
	        Iterator<String> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            String key = keyIt.next();
	            Double comp1 = passedMap.get(key);
	            Double comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
}
