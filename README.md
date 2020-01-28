# Customer Manager

This project is made to manage customer accounts in more sophisticated way than using spreadsheet.  It also makes searching for customers ased on license conditions easier.

## Getting Started

Clone the repo to your local machine, install the following, and build and run the app.

### Prerequisites and Installation

	1. [Java 12](https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase12-5440181.html) - Database
		1. Download the zip
		2. Extract
		3. Add '...\gradle-5.4\bin' to your PATH variable
		
    2. [Gradle 5.4](https://gradle.org/releases/) - Dependency Management
		1. Download the zip
		2. Extract
		3. Add '...\Java\jdk-12.0.1\bin' to your PATH variable
		
    3. [PostgresSQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) - Database
		1. Download and run the executable
		2. Set your passsword in the installation guide
		3. Open pgAdmin app in your file directory and it should launch an in-browser database management view

## Using the app
	1. Run the app locally from your IDE
	2. Will generate tables in postgres automatically on starting the app and drop them when it ends
		* This can be changed in application.properties
		* sql script with sample data can be run from command line or browser; located in resources
	3. Send REST calls to http://localhost:9090/{API call}
		
## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Web framework used
* [Gradle](https://gradle.org/releases/) - Dependency Management

## Authors

* **Kyle Gee** - kyle.gee012@gmail.com


## Future enhancements
	1. Robust testing, logging, validation, and exception handling
	2. API documentation
	3. Audit trail to track database changes and provide way to do simple analytics on license changes
	4. Facilitate bulk data upload
	5. User friendly UI for inputting data