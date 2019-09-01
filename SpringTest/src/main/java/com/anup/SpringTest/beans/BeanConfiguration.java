package com.anup.SpringTest.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean("BeanDog")//you can use this bean
    public Animal Dog() {
        return new AnimalType("Bean Dog", "Boow Boow");
    }

    @Bean
    public Animal getDog() {
        return new AnimalType("Dog", "Boo Boo");
    }


    @Bean
    @Qualifier("Dogie") // should not use qualifier here. However it doesn't throw an error.
    public Animal getDogUsingQualifier() {
        //You should name your bean using @Bean("abc").@Qualifer is used only to select a bean via the bean name
        //HOwever you can still use it ,but then you would have to compulsarily use @Qualifier with Autowire as well
        return new AnimalType("Dog", "Boo Boo");
    }

    /*@Bean
    public Zoo getBeanDogZooWithQualifier(@Autowired AnimalType Dogie) {
        //This does not work since Autowired does not know bean with name Dogie .
        //Normally Autowired can detect beans using bean name but not qualifier name on the bean .
        //Either replace the bean name with Dogie and remove @Qualifier or add @Qualifier her with name Dogie
        return new Zoo(Dogie);
    }
*/
    @Bean
    public Zoo getBeanDogZooWithQualifier(@Autowired @Qualifier("BeanDog") AnimalType xyz){
        return new Zoo(xyz);
    }

    /*@Bean
    public Zoo getBeanDogZooWithQualifierOnOnlyBean(@Autowired  AnimalType Dogie) {
        //It does not work .It is unable to find bean with qualifier name Dogie
        return new Zoo(Dogie);
    }*/

    @Bean
    @Scope("singleton")
    public Zoo getBeanDogZoo(@Autowired AnimalType BeanDog) {
        System.out.println("In getBeanDogZoo.This would be called only once");
        //This works since @Autowired works with bean name
        return new Zoo(BeanDog);
    }

    @Bean
    @Scope("prototype")
    public Zoo getDogZoo(@Autowired AnimalType getDog) {
        System.out.println("IN getDogZoo. This would be called everytime you ask for this bean  ");
        //this thing works since i have written getDog and @Autowired can work with method name
        return new Zoo(getDog);
    }

    /*
    By using the @Qualifier annotation, we can eliminate the issue of which bean needs to be injected.
    @Qualifier is mostly used with Autowired.
    It allows you to map the name in qualifer with the name mentioned against bean /component
    @Autowired by default autowires by  type so in case of ambiguity you can use quailifer to specify
    which bean is to be used
    if both the @Qualifier and @Primary annotations are present, then the @Qualifier annotation will have precedence.
     */
}
