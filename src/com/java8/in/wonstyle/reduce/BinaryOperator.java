package com.java8.in.wonstyle.reduce;

import java.util.List;

@FunctionalInterface
interface BinaryOperator<T> {
	public boolean equals(Object obj); // Will Compiled, still BinaryOperator is functional interface because the equal method is the method of Object

	public String toString(); // Same as above

	// public Class<?> getClass();//Compile Error, because it is final method of Object
	
	public T apply(T left, T right);//If this function is missing then it will give compile error and also no other abstract method are allowed to create because it is functional interface except the method of Object class (not final)
	
	/**
	 * And now we would like to use this functional interface 
	 * to reduce the values from a list to a single value. So, we could use it as follows:
	 */
	static <T> T reduce(BinaryOperator<T> operator,T seed, List<T> source){
		    for(T item: source) {
		       seed = operator.apply(seed, item);
		    }
		    return seed;
		}	
}
