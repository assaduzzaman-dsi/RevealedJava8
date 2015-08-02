package com.java8.in.wonstyle.stream.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashmapCompute {
	public static void main(String[] args) {
		// We'll be using this simple map
		// Unfortunately, still no map literals in Java 8..
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		 
		// Compute a new value for the existing key
		System.out.println(map.compute("A", 
		    (k, v) -> v == null ? 42 : v + 41));
		System.out.println(map);
		 
		// This will add a new (key, value) pair
		System.out.println(map.compute("X", 
		    (k, v) -> v == null ? 42 : v + 41));
		System.out.println(map);
		
		
		map.forEach((k,v) -> System.out.println(k + "=" + v));
		
		
		
		//------------------------------------
		 /**
		    * Using HashMap
		    */
		    System.out.println( "Using plain hash map with balanced trees:" );
		    
		    HashMap stringMap = new HashMap();
		    
		    for( int i = 0; i < 100; ++i )
		    {
		         stringMap.put( "index_" + i, String.valueOf( i ) );
		    }
		    
		    stringMap.values().forEach( System.out::println );
		    
		    /**
		    * Using LinkedHashMap
		    */
		    System.out.println( "Using LinkedHashMap:" );
		    
		    LinkedHashMap linkedHashMap = new LinkedHashMap();
		    
		    for( int i = 0; i < 100; ++i )
		    {
		         linkedHashMap.put( "index_" + i, String.valueOf( i ) );
		    }
		    
		    linkedHashMap.values().forEach( System.out::println );
	
	}
}
