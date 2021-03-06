package com.inmar.code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PersonImporter {

	static PersonPublisher personPublisher = null;

	public static void main(String[] args) {

		if (0 < args.length) {
			try {

				// Create List of persons from the file
				List<Person> persons = readPersonsFromFile(args[0]);
				if (persons != null && persons.size() > 0) {
					personPublisher = new PersonPublisher();
					for (Person p : persons) {
						personPublisher.publishMessage(p);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Invalid arguments count:" + args.length);
			System.exit(0);
		}

	}

	/*
	 * This method check whether file exist , if yes it the will read the file
	 * and define it is csv or json from its extension. Based on extension
	 * appropriate parser is called.
	 */
	private static List<Person> readPersonsFromFile(String fileName) {
		List<Person> persons = null;
		try {
			FileReader reader = new FileReader(fileName);
			int index = fileName.lastIndexOf('.');
			if (index > 0) {

				String extension = fileName.substring(index + 1);
				if (extension.equalsIgnoreCase("csv")) {
					persons = csvFileParser(reader);
				} else if (extension.equalsIgnoreCase("json")) {
					persons = jsonFileParser(reader);
				} else {
					System.out.println("Accepts csv or json file format");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return persons;
	}

	/*
	 * Parse csv file and return the list of persons.
	 */
	private static List<Person> csvFileParser(FileReader reader)
			throws FileNotFoundException {
		String line=null;
		List<Person> persons = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(reader)) {
			// read the first line from the text file
			line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				// use string.split to load a string array with the values from
				// each line of the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				Person person = ValidateAndCreatePersonObject(attributes[0], attributes[1], attributes[2]);;
				// adding Person into arrayList
				if (person != null) {
					persons.add(person);

				}
				// read next line before looping if end of file reached, line
				// would be null
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.err.println("The UUID value is invalid for record:"+ line);
		}
		return persons;
	}

	
	/*
	 * Parse json file. Handle exception based on json data.
	 */
	@SuppressWarnings("unchecked")
	private static List<Person> jsonFileParser(FileReader reader) {
		List<Person> persons = new ArrayList<>();
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try {
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONArray personList = (JSONArray) obj;
			// Iterate over person array
			Iterator<JSONObject> itr = personList.iterator();
			while (itr.hasNext()) {
				JSONObject personObject = itr.next();
				Person person = parsePersonObject(personObject);
				if (person != null) {
					persons.add(person);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new IllegalStateException("Invalid JSON: " + jsonParser, e);
		}
		return persons;
	}

	/*
	 * Creating person from jsonobject
	 */
	private static Person parsePersonObject(JSONObject person) {
		try {
			// Get person object within list
			JSONObject personObject = (JSONObject) person.get("person");
			return ValidateAndCreatePersonObject(personObject.get("firstName").toString(),
					personObject.get("lastName").toString(),personObject.get("uuId").toString());
		} catch (java.lang.IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Creating person from jsonobject
	 */
	private static Person ValidateAndCreatePersonObject(String firstName, String lastName, String uuid) {
		try {
			if(firstName == null || firstName.length() == 0) {
			    System.err.println("The first name value is null or empty for record:"+ firstName+":"+lastName+":"+uuid);
		
			} else if (uuid == null || uuid.length() == 0 ){
				System.err.println("The UUID value is null or empty or record:"+ firstName+":"+lastName+":"+uuid);
			} else
			return new Person(firstName,lastName,UUID.fromString(uuid) );
		} catch (java.lang.IllegalArgumentException e) {
			e.printStackTrace();
		}  
		return null;
	}
}
