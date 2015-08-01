package com.java8.in.wonstyle.consumer;

import java.util.Arrays;
import java.util.List;

public class ConsumerTest {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		//Look at all the boilerplate code necessary to create a consumer to simply print all the elements of a list:
		Consumer.forEach(new Consumer<Integer>(){
		   @Override
		   public void accept(Integer n) {
		      System.out.println(n);
		   }
		},numbers);
		
		System.out.println("==============================================");
		Consumer.forEach(n -> {System.out.println(n);}, numbers);
		System.out.println("==============================================");
		Consumer.forEach(n -> System.out.println(n), numbers);
		System.out.println("==============================================");
		Consumer.forEach(System.out::println, numbers);//Functional reference
		
	}
}
