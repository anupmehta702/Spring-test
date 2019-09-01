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
		//test.testDependency();

		Zoo dogZoo =(Zoo)applicationContext.getBean("getDogZoo");
		dogZoo.getZooAnimals();
		/*
		Output -
		IN getDogZoo. This would be called everytime you ask for this bean
		Dog making sound Boo Boo
		*/

		Zoo dogZooToTestProtoScope =(Zoo)applicationContext.getBean("getDogZoo");
		dogZooToTestProtoScope.getZooAnimals();
		/*
		Output(called again to test prototype)  -
		IN getDogZoo. This would be called everytime you ask for this bean
		Dog making sound Boo Boo
		*/


		Zoo getBeanDog =(Zoo)applicationContext.getBean("getBeanDogZoo");
		getBeanDog.getZooAnimals();
		/*
		Output -
		In getBeanDogZoo.This would be called only once (This is printed immdly once the appln starts)
		Bean Dog making sound Boow Boow
		 */

		Zoo getBeanDogToTestSingleton =(Zoo)applicationContext.getBean("getBeanDogZoo");
		getBeanDogToTestSingleton.getZooAnimals();

		Zoo getBeanDogZooWithQualifier =(Zoo)applicationContext.getBean("getBeanDogZooWithQualifier");
		getBeanDogZooWithQualifier.getZooAnimals();
	}

}
