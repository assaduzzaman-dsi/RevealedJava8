package com.java8.in.wonstyle.java8default;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8DefaultInterfaceTest {
	public static void main(String[] args) {
		Predicate<Integer> isOdd = n -> n % 2 == 0;
		Function<String, Integer> atoi = s -> Integer.valueOf(s);
		BinaryOperator<Integer> product = (x, y) -> x * y;
		Comparator<Integer> maxInt = (x,y) -> x > y ? x : y;
		Consumer<String> printer = s -> { System.out.println(s); };
		Supplier<String> producer = () -> "Hello World";
		Runnable task = () -> { System.out.println("I am a runnable task");  };
		
		int oddSum = Arrays.asList("1","2","3","4","5").stream()
                                        .map(n -> Integer.valueOf(n))
                                        .filter(n -> n % 2 != 0)
                                        .reduce(0, (x,y) -> x + y); // 9
	}
}
