package com.inmar.code;

/*
 * PersonPublisher, which takes no arguments in its constructor. 
 * It should have a method, publishMessage, which takes a Person as its sole argument.
 * The method does not need any functionality other than printing the last name and first name of the Person to standard out.
 * 
 */
public class PersonPublisher {

	public PersonPublisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void publishMessage(Person person) {
		System.out.println("FirstName : " + person.getFirstName()
				+ "   LastName : " + person.getLastName());
	}
}
