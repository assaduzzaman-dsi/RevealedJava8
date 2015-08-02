package com.java8.in.wonstyle.stream.hashmap;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

public class EZMap<T> {
    public static void main(String[] args) {
            Map<String,Object> m = hashMap(
                    bob -> 5,
                    TheGimp -> 8,
                    incredibleKoolAid -> "James Taylor",
                    heyArnold -> new Date()
            );
            System.out.println(m);
    }

    private final Map<String,T> map;

    private EZMap(Map<String,T> _map, Function<Object,T>[] entries) {
        map=_map;
        for( Function<Object,T> entry: entries ) {
            final Method m;
            try {
                m = entry.getClass().getDeclaredMethod("apply", Object.class);
            } catch (NoSuchMethodException nsme ) { throw new RuntimeException(nsme); }
            final Parameter p = m.getParameters()[0];
            
            
            final Parameter[] args =m.getParameters();
            for(Parameter pp : args) {
            	System.out.println("parameter:" + pp.getName());
            }
            
            final String key = p.getName();
            final T value = entry.apply(null);
            map.put(key,value);
        }
    }

    public static <R> Map<String,R> hashMap(Function<Object, R>... entries) {
        return new EZMap<R>(new HashMap<>(), entries).map;
    }

    public static <R> Map<String,R> treeMap(Function<Object, R>... entries) {
        return new EZMap<R>(new TreeMap<>(), entries).map;
    }

}