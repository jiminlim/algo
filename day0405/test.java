package com.corona.day0405;

public class test {

	public static void main(String[] args) {
		long a = 9;
		long a5 = (long) Math.pow(a, 5);
		long a4 = (long) Math.pow(a, 4);
		long a3 = (long) Math.pow(a, 3);
		long a2 = (long) Math.pow(a, 2);
		long as = a5+a4+a3+a2+a;
		System.out.println(as%8);
	}

}
