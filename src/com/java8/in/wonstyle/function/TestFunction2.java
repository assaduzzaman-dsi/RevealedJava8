package com.java8.in.wonstyle.function;

import java.util.Arrays;
import java.util.List;

public class TestFunction2 {

	public static void main(String[] args) {
		List<String> digits = Arrays.asList("1","2","3","4","5","6","7","8","9");
		List<Integer> vals = Function2.map((s,x) -> Function2.stringToSomOfset(s, x), digits, 2);
		System.out.println(vals);
		
		System.out.println("sort form");
		
		List<Integer> shortFormVals = Function2.map(Function2::stringToSomOfset, digits, 2);
		List<Integer> normal = Function2.map(NormalClass::stringToSomOfset, digits, 2);
		
		System.out.println(shortFormVals);
		System.out.println(normal);
	}

}
