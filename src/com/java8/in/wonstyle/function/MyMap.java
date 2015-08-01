package com.java8.in.wonstyle.function;

import java.util.ArrayList;
import java.util.List;

public class MyMap {
	   static <T,R> List<R> map(Function<T,R> function, List<T> source){
		   List<R> destiny = new ArrayList<>();
		   for(T item : source) {
		      R value = function.apply(item);
		      destiny.add(value);
		   }
		   return destiny;
		}
}
