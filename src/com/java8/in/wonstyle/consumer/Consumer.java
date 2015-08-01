package com.java8.in.wonstyle.consumer;

import java.util.List;

@FunctionalInterface
public interface Consumer<T> {
	public void accept(T t);
	
	/**
	 * we could use implementations of this interface to consume the elements of
	 * a list and do something with them, like printing them to the main output
	 * or sending them over the network, or whatever we could consider
	 * appropriate. For this example, let’s just print them to the output:
	 */
	static <T> void forEach(Consumer<T> consumer, List<T> source) {
	    for(T item: source) {
	       consumer.accept(item);
	    }
	}
}
