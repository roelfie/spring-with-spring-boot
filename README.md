This project was created with the [Spring Initializr](start.spring.io).

# Spring with Spring Boot

From the LinkedIn course [Learning Spring with Spring Boot](https://www.linkedin.com/learning/learning-spring-with-spring-boot-2).

## Embedded Databases

Add the following dependencies to pom.xml and when your application starts, Spring Boot will automatically launch an in-memory h2 database:

```xml        
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

If the following files are present in `src/main/resources` then the Spring JDBC `ScriptUtils` will 
* `schema.sql` => create a schema for you
* `data.sql` => load the data for you

