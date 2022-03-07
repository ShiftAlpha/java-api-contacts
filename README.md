# Dhirav Rana Acoer Take-Home Test

- # Tools Used
    - VS Code with java, lombok, & springboot mongo extensions
    - Github

- # Core App
    - Contacts storing app
    - Contact attributes are to be First Name, Surname, & phonenumber
    - Phonenumber should be used to delete entire contact as well as compared to when storing new contacts
    - Ascending & Descending sort to be used via Names
    - Delimeter or .split() method Java to manipulate and sort contact via Surname
    - Completed everything except sort methods, Mongo imports to be used, alternatively .sort via JAVA or Monngo. 
    - Search via search term(number , first name, surname), otherwise ResourceNotFound Exception to be thrown

- # Additional Files & code commented & committed
- # What i would've completed should there be any requests made : 
    Security protocols; WebConfig, SexcurityXML, java security config, Spring Security, Further Error Handling
    , Bug fixes, Further tests

# Structure

The project has a simple Java project structure with the following packages (in **src/main/java**)

* **com.acoer.test.contact:** This is the main package, classes directly in this package should not be touched.
* **com.acoer.test.contact.controller:** Contains the controller side of the MVC pattern that processes  the RESTful requests
* **com.acoer.test.contact.domain:** Contains the domain classes that encapsulate the information that will be persisted in MongoDB
* **com.acoer.test.contact.service:** Contains the service implementation responsible for the connection with MongoDB

A basic application configuration can be found in **src/main/resources/application.properties** with the following settings:

* **spring.data.mongodb.uri:** Connection string to the mongoDB. We created a DB for you to connect to it and persist the data, so there is no need to change it.
* **server.port:** HTTP port in which the application server will start up and will be listening for requests. You can change it if you wish.

## Database

This project connects to a MongoDB database we have pre-configured for the challenge. If you wish to connect using a client like Robo3T or similar please use the URI set in **spring.data.mongodb.uri** in the file **src/main/resources/application.properties**

# Swagger

This Microservice has Swagger UI integrated in it, so you can test the REST endpoints. To get to it put the following in a web browser: [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui)

# Running the application

This is a standard SpringBoot application, you can run it by executing the following command from the project root directory:

```
./mvnw spring-boot:run
```

