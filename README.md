## spring-boot-hibernet-search-spring-security
In this project i will discuss the basics of Hibernate Search and spring security in spring boot project, how to configure it, and we'll implement some simple queries.

### Basics of Hibernate Search
Whenever we have to implement full-text search functionality, using tools we're already well-versed with is always a plus.

In case we're already using Hibernate and JPA for ORM, we're only one step away from Hibernate Search.

Hibernate Search integrates Apache Lucene, a high-performance and extensible full-text search-engine library written in Java. This combines the power of Lucene with the simplicity of Hibernate and JPA.

Simply put, we just have to add some additional annotations to our domain classes, and the tool will take care of the things like database/index synchronization.

Hibernate Search also provides an Elasticsearch integration; however, as it's still in an experimental stage, we'll focus on Lucene here.

### Spring Security Form Login
This article is going to focus on Login, Registration, Password update, Logout with Spring Security. We're going to build on top of the simple previous Spring MVC example, as that's a necessary part of setting up the web application along with the login mechanism.

### Spring-boot-hibernet-search-spring-security project import
1. `git clone https://github.com/ahasanhabibsumon/spring-boot-hibernet-search.git`

### Spring-boot-hibernet-search-spring-security project run
1. import on IDE
2. create database `basic_security`
3. change databse username and password
4. go to browser and enter `http:localhost:8092/`
5. in the login page under click on registraion link
