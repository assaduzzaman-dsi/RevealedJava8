package com.java8.in.wonstyle.functional.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ReferenceToStaticMethod {
	 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer>  numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,15,16);
        List<Integer> primeNumbers = ReferenceToStaticMethod.findPrimeNumbers(ReferenceToStaticMethod::isPrime,numbers);
        List primeNumbersLamdas = ReferenceToStaticMethod.findPrimeNumbers(a -> ReferenceToStaticMethod.isPrime(a),numbers);
        
        System.out.println("Prime Numbers are "+primeNumbers + " lamda version " + primeNumbers);
    }
 
    public static boolean isPrime(Integer number) {
        if(number == 1 ){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false; 
            }
        }
        return true; 
    }
 
    public static List findPrimeNumbers(Predicate<Integer> predicate,List<Integer> list) {
        List sortedNumbers = new ArrayList();
        list.stream().filter((i) ->(predicate.test(i))).forEach((i) -> {
            sortedNumbers.add(i);
        });
        return sortedNumbers;
 
    }
}