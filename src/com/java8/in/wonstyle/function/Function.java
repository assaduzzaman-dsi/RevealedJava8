package com.java8.in.wonstyle.function;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Function<T, R> {
	public boolean equals(Object obj); // Will Compiled, still BinaryOperator is functional interface because the equal method is the method of Object

	public String toString(); // Same as above

	// public Class<?> getClass();//Compile Error, because it is final method of Object

	public R apply(T t);//If this function is missing then it will give compile error and also no other abstract method are allowed to create because it is functional interface except the method of Object class (not final)

	static <T, R> List<R> map(Function<T, R> function, List<T> source) {
		List<R> destiny = new ArrayList<>();
		for (T item : source) {
			R value = function.apply(item);
			destiny.add(value);
		}
		return destiny;
	}

}
