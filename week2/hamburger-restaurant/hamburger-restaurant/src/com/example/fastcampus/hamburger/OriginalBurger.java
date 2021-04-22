package com.example.fastcampus.hamburger;

public class OriginalBurger implements Hamburger {
	final static int price = 1000;
	final static String ingredient = "Ham";
	final static String name = "OriginalBurger";
	
	@Override
	public int showPrice() {
		System.out.println("햄버거의 가격은"+price+"입니다.");
		return price;
		
	}
	@Override
	public String Matarial() {
		System.out.println("햄버거의 재료는"+ingredient+"입니다.");
		return ingredient;
		
	}
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public String getBurgerName() {
		return name;
	}

	//To-do 인터페이스에서 만든 메서드를 재정의하여 구현합니다.
	
}
