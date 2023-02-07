package com.project._2023_02_07;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation
public class A1 {
    public static void main(String[] args) {
        Person person = new Child("!!!");
        person.showInfo();

    }
}

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@interface MyAnnotation {

}

@Getter
@Setter
@AllArgsConstructor
class Person {

    @MyAnnotation
    private String name;

    void showInfo() {
        System.out.println("Person: " + name);
    }

}

class Child extends Person {

    public Child(String name) {
        super(name);
    }

    @Override
    void showInfo() {
        System.out.println("Child: ");
    }
}