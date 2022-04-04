package model;

import structures.LinkedList;

public class ToTest {
	public static void main(String[]args) {
		LinkedList<String> a=new LinkedList<>();
		a.add("1");
		a.add("2");
		String b=a.get("1");
		System.out.println(b);
	}
}
