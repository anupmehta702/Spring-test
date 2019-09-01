package com.anup.SpringTest.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SpringTest {
    public Parent child2;
    public Parent child;
    public Parent child1;

    @Autowired
    public SpringTest(@Qualifier("Child2") Parent child2,
                      Parent child,
                      @Qualifier("Child1") Parent child1) {
        this.child2 = child2;//assigning using qualifier
        this.child = child; // assigned due to primary
        this.child1 = child1; //assigned using qualifier
    }

    public void testDependency() {
        child2.displayClass();
        child.displayClass();
        child1.displayClass();
    }

}

/*
@SpringBootApplication
@Configuration
@ComponentScan("com.anup.SpringTest")
class SpringTestApplicationForComponent {
    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(com.anup.SpringTest.beans.SpringTestApplication.class, args);
        SpringTest test = (SpringTest) applicationContext.getBean(SpringTest.class);
        test.testDependency();
    }
*/
/*
    Output -
    In child 2
    In child 1
    In child 1
*//*

}
*/

