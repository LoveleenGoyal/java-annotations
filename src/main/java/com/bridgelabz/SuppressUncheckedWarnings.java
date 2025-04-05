package com.bridgelabz;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(2.0);
        list.add("abc");
        System.out.println(list);
    }
}
