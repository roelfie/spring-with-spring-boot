package top.kerstholt.springwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication annotation
 * <ol>
 *     <li>designates this class as a @Configuration file</li>
 *     <li>makes this class the root of the (implicit) @ComponentScan</li>
 *     <li>initiates Spring Boot's auto-configuration (based on jars that are on the classpath)</li>
 * </ol>
 */
@SpringBootApplication
public class SpringWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithSpringBootApplication.class, args);
	}

}
