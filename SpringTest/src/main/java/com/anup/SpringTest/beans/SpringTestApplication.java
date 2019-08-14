package com.anup.SpringTest.beans;

import com.anup.SpringTest.components.SpringTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.anup.SpringTest")
public class SpringTestApplication {
public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext =SpringApplication.run(SpringTestApplication.class, args);
		SpringTest test =(SpringTest)applicationContext.getBean(SpringTest.class);
		test.testDependency();

		Zoo dogZoo =(Zoo)applicationContext.getBean("getDogZoo");
		dogZoo.getZooAnimals();

		Zoo dogZooToTestProtoScope =(Zoo)applicationContext.getBean("getDogZoo");
		dogZooToTestProtoScope.getZooAnimals();

		Zoo getBeanDog =(Zoo)applicationContext.getBean("getBeanDogZoo");
		getBeanDog.getZooAnimals();

		Zoo getBeanDogToTestSingleton =(Zoo)applicationContext.getBean("getBeanDogZoo");
		getBeanDogToTestSingleton.getZooAnimals();

		Zoo getBeanDogZooWithQualifier =(Zoo)applicationContext.getBean("getBeanDogZooWithQualifier");
		getBeanDogZooWithQualifier.getZooAnimals();
	}

}
