package com.java8.in.wonstyle.supplier;

public class SupplierTest {

	public static void main(String[] args) {

		int value = Supplier.calculate(new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				return Supplier.generateX();
			}
		}, new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				return Supplier.generateY();
			}
		});

		System.out.println(value);
		
		int valueLamda = Supplier.calculate(()->Supplier.generateX(),()->Supplier.generateY());

		System.out.println(valueLamda);
	}

}


