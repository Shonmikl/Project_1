package com.project._2023_02_07;

import java.lang.annotation.*;

public class A2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class VIVO = Class.forName("com.project._2023_02_07.VIVO");
        Annotation annotationV = VIVO.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotationV;
        System.out.println("Ann: " + sm1.OS() + " | " + sm1.releaseData());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String OS() default "Android";
    int releaseData() default 2023;
}

@SmartPhone(releaseData = 2024)
class VIVO {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", releaseData = 2021)
class IPhone {
    String model;
    double price;
}
