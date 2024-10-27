package oop;

import java.util.Stack;

// Superclass
class SuperClass<T> {
    // Public method with generic return type and checked exception
    public T process(T input) throws Exception {
        System.out.println("SuperClass processing: " + input);
        return input;
    }
}

// Subclass that overrides the method
class SubClass extends SuperClass<String> {

    // Overriding method
    @Override
    public String process(String input) throws RuntimeException {
        System.out.println("SubClass processing: " + input);
        return input.toUpperCase();
    }
}

// Another subclass with more restrictive access
class SubClassRestricted extends SuperClass<String> {

    // Overriding method with reduced accessibility
    // uncomment to check access modifier rule
   /*  @Override
     protected String process(String input) throws IllegalArgumentException {
        System.out.println("SubClassRestricted processing: " + input);
        return input.toLowerCase();
    } */
}

// Main class to test the overriding rules
public class OverridingRules {
    public static void main(String[] args) {
        try {

            SuperClass<String> superClass = new SubClass();
            System.out.println(superClass.process("Hello"));

            SuperClass<String> restrictedSuperClass = new SubClassRestricted();
            System.out.println(restrictedSuperClass.process("Hello"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

