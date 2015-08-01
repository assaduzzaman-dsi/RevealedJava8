package com.java8.in.wonstyle.function;

import java.util.Arrays;
import java.util.List;

public class TestFunction {
	public static void main(String[] args) {
		List<String> digits = Arrays.asList("1","2","3","4","5","6","7","8","9");
		List<Integer> numbersOldStyle = Function.map(new Function<String, Integer>() {
		                          @Override
		                          public Integer apply(String digit) {
		                            return Integer.valueOf(digit);
		                          }
		                        }, digits);
		
		System.out.println(numbersOldStyle);
		
		List<Integer> numbersLamdaStyle = Function.map(s -> Integer.valueOf(s), digits);
		System.out.println(numbersLamdaStyle);
		
		List<Integer> numbersLamdaMyStyle = Function.map(s -> Integer.valueOf(s), digits);
		System.out.println(numbersLamdaMyStyle);
		
	
		System.out.println("More compressed form::");

		Function<String, Integer> sortForm = s -> Integer.valueOf(s);
		
		System.out.println(sortForm);
	}
}
