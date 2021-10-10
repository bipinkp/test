package com.inmar.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonImporter {

	static PersonPublisher personPublisher = null;

	public static void main(String[] args) {
		List<Person> persons = readPersonsFromfFile("persons.csv"); // Read data from file
		if (persons.size() > 0) {
			personPublisher = new PersonPublisher();
			for (Person p : persons) {
				personPublisher.publishMessage(p);
			}
		}

	}

	private static List<Person> readPersonsFromfFile(String fileName) {
		List<Person> persons = new ArrayList<>();
		Path pathToFile = Paths.get(fileName); 
		try (BufferedReader br = Files.newBufferedReader(pathToFile,
				StandardCharsets.US_ASCII)) { 
			// read the first line from the text file
			String line = br.readLine(); 
			// loop until all lines are read
			while (line != null) { 
				// use string.split to load a string array with the values from each line of  the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				Person person = createPerson(attributes); 
				// adding Person into arrayList
				if(person !=null){
					persons.add(person); 
					
				}
				// read next line before looping if end of file reached, line would be null
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return persons;
	}

	private static Person createPerson(String[] metadata) {
		try{
		String firstName = metadata[0];
		String lastName = metadata[1];
		UUID uUID = UUID.fromString(metadata[2]); // create and return Person of this metadata
		return new Person(firstName, lastName, uUID);
		}
		catch(java.lang.IllegalArgumentException e){
			e.printStackTrace();
		}
		return null;
	}

}
