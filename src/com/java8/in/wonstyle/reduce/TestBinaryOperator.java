package com.java8.in.wonstyle.reduce;

import java.util.Arrays;
import java.util.List;

public class TestBinaryOperator {
	public static void main(String[] args) {
		/**
		 * Consider now that we have a list of numbers and we would like to obtain 
		 * to summation of them all. Once more, if we intend to use this code as we traditionally 
		 * have done before the release of Java 8 we would be forced to to following verbose definition, as follows:
		 */
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		Integer sum = BinaryOperator.reduce(new BinaryOperator<Integer>() {
		                     @Override
		                     public Integer apply(Integer left, Integer right){
		                        return left + right;
		                     }
		                    },0,numbers);
		System.out.println(sum);
		
		
		/**
		 * Where (x,y) correspond to the two arguments left and right that the
		 * function apply receives, and the body of the expressions would be
		 * what it would return. Notice that, since in this case we have to
		 * specify two arguments, the lambda expressions is required to specify
		 * them within parenthesis, otherwise the compiler could determine which
		 * arguments are for the lambda expression and which are for the reduce
		 * method.
		 */
		Integer sumLamdaStyle = BinaryOperator.reduce((x,y) -> x + y, 0,numbers);
		
		System.out.println(sumLamdaStyle);
		
		System.out.println("More compressed form::");
		
		BinaryOperator<Integer> sortestForm = (x, y) -> x * y;
		System.out.println(sortestForm);
		
		
	}
}
