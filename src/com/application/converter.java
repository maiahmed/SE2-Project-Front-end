package com.application;

import java.util.Vector;

public class converter { 
	 private Strategy strategy;

	   public converter(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public Vector<String> executeStrategy(Vector<String>v){
	      return strategy.sort(v);
	   }

}
