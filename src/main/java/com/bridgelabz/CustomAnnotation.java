package com.bridgelabz;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Loveleen")
    public void myTask() {
        System.out.println("Task Completed.");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        TaskManager taskManager = new TaskManager();
        Class<?> cls = taskManager.getClass();

        Method method = cls.getMethod("myTask");
        if(method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Method Name: " + method.getName());
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

    }
}
