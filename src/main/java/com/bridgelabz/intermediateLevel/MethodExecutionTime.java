package com.bridgelabz.intermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

public class MethodExecutionTime {
    @LogExecutionTime
    public void HeavyTask() throws InterruptedException {
        long startTime = System.nanoTime();
        System.out.println("Program Started....");
        Thread.sleep(200);
        long endTime = System.nanoTime();

        System.out.println("Time taken to execute program: " + (endTime - startTime));
    }
    public static void main(String[] args) throws Exception{
        MethodExecutionTime obj = new MethodExecutionTime();
        Class<MethodExecutionTime> cls = MethodExecutionTime.class;
        Method method = cls.getMethod("HeavyTask");
        method.invoke(obj);

    }
}
