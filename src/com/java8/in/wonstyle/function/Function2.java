package com.java8.in.wonstyle.function;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Function2<T, R, X> {
	public boolean equals(Object obj); 

	public R apply(T t, X x);//If this function is missing then it will give compile error and also no other abstract method are allowed to create because it is functional interface except the method of Object class (not final)

	static <T, R, X> List<R> map(Function2<T, R, X> function, List<T> source, X x) {
		List<R> destiny = new ArrayList<>();
		for (T item : source) {
			R value = function.apply(item,x);
			destiny.add(value);
		}
		return destiny;
	}
	
	static Integer stringToSomOfset(String strVal, Integer offset) {
		return Integer.valueOf(strVal) + offset;
	}
	

}
