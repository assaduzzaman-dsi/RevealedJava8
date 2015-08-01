package com.java8.in.wonstyle.predicate;

import java.util.Arrays;
import java.util.List;

public class TestPredicate {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> onlyOdds = Predicate.filter(new Predicate<Integer>(){
		                           @Override
		                           public boolean test(Integer n) {
		                              return n % 2 != 0;
		                           }
		                          }, numbers);
		
		System.out.println(onlyOdds);
		
		
		List<Integer> onlyOddsLamda = Predicate.filter( n -> n % 2 != 0, numbers);
		
		System.out.println(onlyOddsLamda);
		
		
	}
}
