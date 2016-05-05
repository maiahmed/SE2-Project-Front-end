package com.application;

import java.util.Vector;

public class DateStrategy implements Strategy {

	@Override
	public Vector<String> sort(Vector<String> v) {
		// TODO Auto-generated method stub 
		Vector<String>ans=new Vector<String>(); 
		for(int i=2;i<v.size();i+=4) 
		{
			ans.addElement(v.get(i)); 
			ans.addElement(v.get(i+3));
		}
		return ans;
	} 
	

}
