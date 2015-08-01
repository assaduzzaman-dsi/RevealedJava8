package com.java8.in.wonstyle.supplier;

@FunctionalInterface
public interface Supplier<T> {
	public T get();
	
	/*
	 * A classical idiom is to use this type of interface to encapsulate an
	 * expensive calculation and differ its evaluation until needed, something
	 * typically known as lazy evaluation. For example:
	 */
	public static int generateX() {
		  return 0;
		}
		 
		public static int generateY() {
		   //some expensive calculation here
		   return 1;
		}
		 
		public static int calculate(Supplier<Integer> thunkOfX,
		                            Supplier<Integer> thunkOfY) {
		   int x = thunkOfX.get();
		   if(x==0)
		      return 0;
		   else
		      return x + thunkOfY.get();
		}
	/*
	 * By means of passing two suppliers here we defer the evaluation of x and y
	 * until needed. As you can see, if x is equal to 0, y is never needed. So,
	 * by using this idiom we avoid spending a lot of time in a expensive
	 * calculation unnecessarily.
	 */
}
