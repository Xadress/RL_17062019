# CCLoader

A small test project made with Angular 8, SpringBoot 2.1.5 and Java 8.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

JDK 8, Apache Tomcat 8.5, Maven 3.5.x, NodeJs, and NPM.
                                                                                                                                                                                                       
### Installing

Clone the repository on your local machine.

You'll notice that inside our root folder there are 4 modules for the backend (ccloader.web, ccloader.application, etc.) and a directory called 'angular-client' which contains our client's source and compiled code.

The compiled frontend is inside angular-client\dist\angular-client folder. These files will get copied inside our war package in order to build an application containing both FE and BE.

To build our Tomcat-deployable WAR application, we execute the mvn clean package. After that, our WAR file is generated at ccloader.web/target/ccloader.war.

To have our WAR file deployed and running in Tomcat, we need to complete the following steps:

    1) Download Apache Tomcat and unpackage it into a tomcat folder
    2) Copy our WAR file from ccloader.web/target/ccloader.war to the tomcat/webapps/ folder
    3) From a terminal navigate to tomcat/bin folder and execute
        startup.bat run (on Windows)
        startup.sh run (on Unix-based systems)
    4) Go to http://localhost:8080/ccloader

## Using the application

The first page you'll see contains the list of our inserted cards (the first time you enter it will be empty).

To start inserting some cards, click on 'Add new cards', this will bring up a page in which you will have two options:
	1) Insert cards manually: 
		By clicking on the green plus button you will add a new row with empty fields, and you can keep adding as you want until finished.
		After filling all the necessary information just click on 'Confirm' in order to save all the cards.
	2) Select a CSV file from your PC:
		Next to the green plus button, there's an input field to load a csv file from your local PC. In order for this method to work
		the CSV file must contain cards data ordered and formatted as follows:
			"HSBC Canada","5664896316896547","11/2017"
			"Bank of America","4585569856856923","07/2022"
			"Royal Bank of Canada","3562325632365623","04/2020"
		Each row rappresents a card with BankName, CardNumber and ExpiryDate.
		REMEMBER: 
			If you insert multiple cards having the same card number the last in the list will overwrite the others.
			Card numbers should be 16 digits long.
			Even if the date field shows the day, it won't be considered.

## Development

In order to build the Angular client, make sure your development environment includes Node.js® and an npm package manager.
* [AngularSetup](https://angular.io/guide/setup-local) - Necessary to build the client.

## Running the tests

To run the automated tests open a command prompt in the root ccloader source directory and execute the mvn clean install.

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - The backend framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Angular 8](https://angular.io/) - The frontend framework used

Many other side technologies were used to build this project. (e.g. Bootstrap, MomentJs, Ngx-Toastr, etc.)

## Versioning

Git :)

## Authors

* **Raffaele Loseto** 