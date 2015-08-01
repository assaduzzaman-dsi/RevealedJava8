package com.java8.in.wonstyle.predicate;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Predicate<T> {
	public boolean equals(Object obj); // Will Compiled, still BinaryOperator is functional interface because the equal method is the method of Object

	public String toString(); // Same as above

	// public Class<?> getClass();//Compile Error, because it is final method of Object	
	
	public boolean test(T t);//If this function is missing then it will give compile error and also no other abstract method are allowed to create because it is functional interface except the method of Object class (not final)
	
	static <T> List<T> filter(Predicate<T> predicate, List<T> source) {
	    List<T> destiny = new ArrayList<>();
	    for(T item : source) {
	      if(predicate.test(item)){
	         destiny.add(item);
	      }
	    }
	   return destiny;
	}
	
	public static void test() {
		java.util.function.Predicate<Integer> isOdd = n -> n % 2 == 0;
	}
}
