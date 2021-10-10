package com.inmar.code;

import java.util.List;

public class PersonImporter {
	
	static PersonPublisher personPublisher = null;
	
	public static void main(String[] args)
	 { 
		List<Person> persons = readPersonsFromfFile("persons.txt"); // Read data from file
		if(persons.size()>0){
			personPublisher = new PersonPublisher();
			for (Person p : persons) 
			 { 
				personPublisher.publishMessage(p);
			 } 
		}
	 
	}

	private static List<Person> readPersonsFromfFile(String string) {
		// TODO Auto-generated method stub
		return null;
	} 

}
