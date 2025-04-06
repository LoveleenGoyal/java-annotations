package com.bridgelabz.intermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}
public class MaximumLength {
    @MaxLength(10)
    private String userName;

    MaximumLength(String userName){
        this.userName = userName;

        validateUserName();
    }

    public void validateUserName(){
        Field[] fields = this.getClass().getDeclaredFields();

        for(Field field : fields){
            if(field.isAnnotationPresent(MaxLength.class)){
                field.setAccessible(true);

                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                try{
                    Object value = field.get(this);
                    if (value instanceof String) {
                        String strValue = (String) value;
                        if (strValue.length() > maxLength.value()) {
                            throw new IllegalArgumentException("Field '" + field.getName() + "' exceeds max length of " + maxLength.value());
                        }
                        System.out.println("User Created with username: " + userName);
                    }
                }catch (IllegalAccessException e){
                    throw new RuntimeException("Validation failed", e);
                }
            }
        }

    }

    public static void main(String[] args) {
        new MaximumLength("Loveleen");
        //new MaximumLength("VeryLongUsernameExceedingLimit");
    }
}
