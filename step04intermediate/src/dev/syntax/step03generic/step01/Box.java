package dev.syntax.step03generic.step01;

public class Box {
//	private Apple apple;
//
//	public Apple getApple() {
//		return apple;
//	}
//
//	public void setApple(Apple apple) {
//		this.apple = apple;
//	}
	
	// 어떤 타입도 받을 수 있도록 필드의 타입을 Object 타입으로 지정
	private Object anyFruit;

	public Object getAnyFruit() {
		return anyFruit;
	}

	public void setAnyFruit(Object anyFruit) {
		this.anyFruit = anyFruit;
	}
	
	
}
