package com.springboot;

import com.springboot.config.SpringMongoConfig1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * This class is responsbile for spring to start the container
 *
 * @author Vibha
 * @since 05/17/2017
 */

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
		System.out.println("MongoOperation"+mongoOperation);
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}