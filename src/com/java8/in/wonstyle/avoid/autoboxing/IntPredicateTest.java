package com.java8.in.wonstyle.avoid.autoboxing;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IntPredicateTest {

	public static void main(String[] args) {

		IntPredicate eventNumbers = (int t) -> t % 2 == 0;
		System.out.println(eventNumbers.test(1000)); // no boxing
		
		
		Predicate<Integer> oddNumbers = (Integer t) -> t % 2 != 0;
		System.out.println(oddNumbers.test(1000)); // boxing [converting primitive type to reference type]
		
		
		Runnable r = () -> (System.out.println(" hi this is me"));
		
//		r.run();
		
		new Thread(r).start();
		
		
		show(new IntPredicateTest());
	}
	
	public static void show(IntPredicateTest a) {
		int number = 8;
		Runnable r = () -> (System.out.println(number));
		r.run();
		
//		number = 9; //Compile ERROR
	}

}
