package com.java8.in.wonstyle.functional.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReferenceToInstanceMethodOAPO {
	 
    /**
     * @param args the command line arguments
     */
 
 
    public static void main(String[] args) {
        // TODO code application logic here
        List names = new ArrayList();
            names.add("David");
            names.add("Richard");
            names.add("Samuel");
            names.add("Rose");
            names.add("John");
 
           ReferenceToInstanceMethodOAPO.printNames(names,System.out::println);
           System.out.println("Lamda version");
           ReferenceToInstanceMethodOAPO.printNames(names, x -> System.out.println(x));
 
    }
 
 
    private static void printNames(List list, Consumer c ){
        list.forEach(x -> c.accept(x));
    }
}