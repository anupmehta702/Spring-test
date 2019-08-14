package com.anup.SpringTest.components;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Child1")
@Primary
public class Child1 extends Parent {
    @Override
    public void displayClass(){
        System.out.println("In child 1");
    }
}
@Component("Child2")
@Scope("prototype")
class Child2 extends Parent{
    @Override
    public void displayClass(){
        System.out.println("In child 2");
    }
}
