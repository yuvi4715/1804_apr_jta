package com.revature.designpatterns;

public class RequestSweets {

	public static void main(String[] args) {
		new SweetFactory().getSweets("candy").bake();
		new SweetFactory().getSweets("marshmallow").bake();
	}

}
