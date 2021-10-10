package com.inmar.code;

import java.util.UUID;

public class Person {
	public String firstName;
	public String lastName;
	public UUID uuId;
	
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
