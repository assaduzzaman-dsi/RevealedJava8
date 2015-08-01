package com.java8.in.wonstyle.predicate;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Predicate<T> {
	public boolean test(T t);
	
	static <T> List<T> filter(Predicate<T> predicate, List<T> source) {
	    List<T> destiny = new ArrayList<>();
	    for(T item : source) {
	      if(predicate.test(item)){
	         destiny.add(item);
	      }
	    }
	   return destiny;
	}
}
