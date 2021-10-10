## Describe your project

Create a class, PersonPublisher, which takes no arguments in its constructor. It should have a method, publishMessage, which takes a Person as its sole argument. 
The method does not need any functionality other than printing the last name and first name of the Person to standard out.


Create another class, Person, which has three member variables, a String for first name, a String for last name, and a UUID as a unique identifier. Accessor methods should be available for each, and there should be appropriate error checking for invalid inputs during construction. Create a third class, PersonImporter, which is runnable from the command line, and takes a command line argument for filename. The file will be in one of two formats, either a comma-separated, newline delineated, list of Persons (last name, first name, optional UUID), or a list of Persons in JSON format. The PersonImporter must support both formats without any command-line argument that specifies the incoming format. The class should read in and parse the file, construct a PersonPublisher, and call publishMessage for each Person from the file. Alert the user of any problems encountered.

Please submit source code, at least one example file you created to test with, instructions on how to compile, and instructions on how to run in the form ‘java -cp package.PersonPublisher etc