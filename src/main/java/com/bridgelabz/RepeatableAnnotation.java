package com.bridgelabz;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description() default "bug";
    String reportedBy() default "Unknown";
}

class BugTracker {
    @BugReport(description = "NullPointerException when input is null", reportedBy = "Loveleen")
    @BugReport(description = "Fails silently on network error", reportedBy = "Yagyata")
    public void fetchData() {
        System.out.println("Fetching data...");
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            Class<BugTracker> cls = BugTracker.class;
            Method method = cls.getDeclaredMethod("fetchData");

            // Retrieve all BugReport annotations (repeatable)
            if (method.isAnnotationPresent(BugReport.class) || method.isAnnotationPresent(BugReports.class)) {
                BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
                for (BugReport bug : bugReports) {
                    System.out.println("Bug Description: " + bug.description());
                    System.out.println("Reported By: " + bug.reportedBy());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
