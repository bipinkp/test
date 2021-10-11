## Description of the project

<p>Create a class, PersonPublisher, which takes no arguments in its constructor. It should have a method, publishMessage, which takes a Person as its sole argument. 
The method does not need any functionality other than printing the last name and first name of the Person to standard out.</p>

<img width="600" src="https://drive.google.com/uc?export=view&id=1nzYoA0O1f4LnxXNGu4e7stEjj8AxceO8">

<p>Create another class, Person, which has three member variables, a String for first name, a String for last name, and a UUID as a unique identifier. Accessor methods should be available for each, and there should be appropriate error checking for invalid inputs during construction. Create a third class, PersonImporter, which is runnable from the command line, and takes a command line argument for filename. The file will be in one of two formats, either a comma-separated, newline delineated, list of Persons (last name, first name, optional UUID), or a list of Persons in JSON format. The PersonImporter must support both formats without any command-line argument that specifies the incoming format. The class should read in and parse the file, construct a PersonPublisher, and call publishMessage for each Person from the file. Alert the user of any problems encountered.</p>

<img width="500" src="https://drive.google.com/uc?export=view&id=17xJl2cDiO-4VdXeXdzBzth4LGwovGye9">

<p>Create a third class, PersonImporter, which is runnable from the command line, and takes a command line argument for filename. The file will be in one of two formats, either a comma-separated, newline delineated, list of Persons (last name, first name, optional UUID), or a list of Persons in JSON format. The PersonImporter must support both formats without any command-line argument that specifies the incoming format. The class should read in and parse the file, construct a PersonPublisher, and call publishMessage for each Person from the file. Alert the user of any problems encountered.</p>

The Person Importer class contains main method, that accepts the filename as input parameter.

<img width="500" src="https://drive.google.com/uc?export=view&id=1BZm3M3LxEyB6q1gnGxGKf2Z3mujNXUVk">

The files can be distinguished based on its extension. Below is the code which helps to define the type of file and executes appropriate parser.

<img width="500" src="https://drive.google.com/uc?export=view&id=1LkjtToOz-tN0Lm53UBs-mxKPdF70RoEF">

CSV Parser:

It parse the data based on comma separated delimiter (,) and creates list of Person object. Below is the sample code of csv parser

<img width="500" src="https://drive.google.com/uc?export=view&id=1h6CRqmSkghB7GZSgxywbXaVuueVn2j4c">

Json Parser:

It parse the data based on Json format. We used "json-simple-1.1.1.jar" for encode or decode JSON data from file. Below is the sample code of Json parser

<img width="500" src="https://drive.google.com/uc?export=view&id=1FNxMvBaUkCWI6VfNTTxq6quyt3xD57Rm">

## Project Folder Structure:

<img width="500" src="https://drive.google.com/uc?export=view&id=1yBpk_A7-JX0pQUH5Guk8Zgtd2RP42LQ0">


## Execution of project:

1. Compile the java class using json-simple-1.1.1.jar 

```
javac -cp Lib\*.jar -d bin src\com\inmar\code\*.java
````

2. Running the java with input csv file

```
java -cp bin;Lib\json-simple-1.1.1.jar com.inmar.code.PersonImporter person.csv
```
3. Running the java with input JSON file

```
java -cp bin;Lib\json-simple-1.1.1.jar com.inmar.code.PersonImporter person.json
```

## Output

For csv: 

<img width="700" src="https://drive.google.com/uc?export=view&id=1Wutcw-0gvlTdZBxiSorkkF9G0iRLtMNK">

For Json:

<img width="700" src="https://drive.google.com/uc?export=view&id=1G8hRyxIeF5GJ-Ak95TSOGe2PKxu1aCjO">

## Exception Handling

1. Handled invalid filename, empty filename, wrong UUID. etc
2. Handled null pointer exception. 
3. Error validations. 
4. warning messagnes