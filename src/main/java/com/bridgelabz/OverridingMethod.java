package com.bridgelabz;

class Animal {
    void makeSound() {
        System.out.println("Sound of an animal.");
    }
}
class Dog extends Animal {
    @Override
    void makeSound() {
        super.makeSound();
        System.out.println("Sound of dog is Bark.");
    }
}
public class OverridingMethod {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}
