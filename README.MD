# Java AssertJ Workshop

The main goal of this project is to guide you to use AssertJ in your unit tests.
In the last section you can find instructions on how to locally build and run this microservice.

# Sample Contacts Microservice

In the `/contacts-service-parent` folder, there there is a parent Maven Project, along with 4 childs:

* [contacts-service-parent](contacts-service-parent)
  * [contacts-api](contacts-service-parent/contacts-api)
    Defines the DTOs (Data Transfer Objects) used to communicate with the Contacts Service.
  * [contacts-client](contacts-service-parent/contacts-client)
    Defines a Feign client to easily communicate with the Contacts Service for Java Developers.
  * [contacts-client-spring-boot-starter](contacts-service-parent/contacts-client-spring-boot-starter)
    Defines a ready-to-use Feign client for Java Developers using Spring Boot.
  * [contacts-service](contacts-service-parent/contacts-service)
    The actual microservice.


## JUnit vs AssertJ vs generated AssertJ assertions 

See all these points implemented in 
* contacts-service [test mapper folder](contacts-service-parent/contacts-service/src/test/java/com/github/erikrz/contacts/service/mapper).

### Starting the Application

#### Locally

* Run `java -jar contacts-service/target/ContactsService.jar`
* Local swagger URL is available at [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
