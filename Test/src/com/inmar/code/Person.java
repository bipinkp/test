package com.inmar.code;

import java.util.UUID;

/*Person Class, which has three member variables, a String for first name, a
String for last name, and a UUID as a unique identifier*/
public class Person {
	public String lastName;
	public String firstName;
	public UUID uuId;
	
	public Person(String firstName2, String lastName2, UUID uUID2) {
		// TODO Auto-generated constructor stub
		this.firstName=firstName2;
		this.lastName=lastName2;
		this.uuId=uUID2;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public UUID getUuId() {
		return uuId;
	}
	public void setUuId(UUID uuId) {
		this.uuId = uuId;
	}
}
