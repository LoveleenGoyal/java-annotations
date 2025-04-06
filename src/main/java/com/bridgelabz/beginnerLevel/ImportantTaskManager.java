package com.bridgelabz.beginnerLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

public class ImportantTaskManager {
    @ImportantMethod(level = "LOW")
    public void task1() {
        System.out.println("Task 1");
    }

    @ImportantMethod()
    public void task2() {
        System.out.println("Task 2");
    }

    @ImportantMethod(level = "MEDIUM")
    public void task3() {
        System.out.println("Task 3");
    }

    public static void main(String[] args) {
        ImportantTaskManager importantTaskManager = new ImportantTaskManager();
        Class<?> cls = importantTaskManager.getClass();

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + importantMethod.level());
                System.out.println("------------------------");
            }
        }
    }
}

