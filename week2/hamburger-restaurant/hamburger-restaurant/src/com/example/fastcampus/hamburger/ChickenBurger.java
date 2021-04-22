package com.example.fastcampus.hamburger;

public class ChickenBurger implements Hamburger {
	final static int price = 2000;
	final static String ingredient = "Chicken";
	final static String name = "ChickenBurger";
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
