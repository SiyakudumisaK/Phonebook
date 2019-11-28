#PhoneBook

#### Purpose

The solution is a Java command line application, which provides the following functionality:
 - Stores name and phone numbers via command `ADD`
 - Displays the content via command `SHOW`
 - Compares the names of the current phone book with a given list of names via command `COMPARE`    

#### Solution

The solution is developed in `Java 8`. Using `maven` as the dependency management tool. It leverages 
the Command design pattern. Making it extendable. In lieu of a database - a file has been used to store data.
Every time the application starts, it loads the content of the file in to an in-memory TreeMap, so the names
are sorted in natural order at all times. At the end of the execution the application overwrites the file
with the new content of the TreeMap. A better way to solve this would be making it a Spring boot application, 
using Spring Data Jpa repository along with a database. This can be still be done as a future enhancement, without
much refactoring (which is why I have made the repository an interface).

The following assumption were made during developing:

- The names stored in phone book are case insensitive. So - `Sam` and `sam` are the same.
- Each name is unique in the phone book. So if an existing name is added again, it will replace the previous entry.


#### Running the app

##### Pre-requisite
  - JDK 1.8

##### Input mode
Input can be provided directly in the CMD screen or via files.

- StdIn
  
Navigate to project folder and then run the following command:
 
```
./mvnw clean install
./mvnw exec:java
```

Then follow the instructions given.

- Files

Navigate to project folder and then run the following command:
 
```
./mvnw exec:java -Dexec.args="<file-name-with-complete-or-relative-path>"
```
For example:
```
./mvnw exec:java -Dexec.args="src/main/resources/example1.txt"
```

Alternatively, navigate to project folder and then run the following command:

``` 
./mvnw clean compile assembly:single
```

- StdIn
```
java -jar target/phonebook-0.0.1-SNAPSHOT-jar-with-dependencies.jar 
```
Then follow the instructions given.

- File
```
java -jar target/phonebook-0.0.1-SNAPSHOT-jar-with-dependencies.jar <file-name-with-complete-or-relative-path>
```
For example,

``` 
java -jar target/phonebook-0.0.1-SNAPSHOT-jar-with-dependencies.jar src/main/resources/example1.txt 
```
 
