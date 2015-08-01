package com.java8.in.wonstyle.functional.reference;

import java.util.function.Function;

public class TestFunctionalRef {
	public static void main(String[] args) {
		Function<String, Integer> ss =  Integer::parseInt; 
		Function<String, Integer> xx = (b) -> Integer.parseInt("4");
		System.out.println(ss.apply("3"));
		
		System.out.println("xx==" + xx.apply("9"));
	}
}
