package com.mystore.utilities;

import com.github.javafaker.Faker;

public class JavaFakerData {

	public static String firstName;
	public static String lastName;

	Faker faker = new Faker();

	public void fakerData() {
		
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
	}

}
