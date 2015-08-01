package com.java8.in.wonstyle.functional.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ReferenceToConstructor {
	 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         List<Double>  numbers = Arrays.asList(4.0,9.0,16.0,25.0,36.0);
         List squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers,Double::new);
         System.out.println("Square root of numbers = "+squaredNumbers);
         
         List squaredNumbersLamdaVersion = ReferenceToConstructor.findSquareRoot(numbers, x -> new Double(x));
         
         System.out.println("Squar root of numbers lamda version = " + squaredNumbersLamdaVersion);
    }
 
    private static List findSquareRoot(List<Double> list, Function<Double,Double> f){
        List result = new ArrayList<>();
        list.forEach(x -> result.add(f.apply(Math.sqrt(x))));
        return result;
    }
}
