package oop;

import model.Animal;
import model.Dog;
import model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Demo {
    public <T> void walk(List<T> l){
        Animal animal = (Animal) l.get(0);
        if(l.get(0) instanceof Animal) {
            ((Dog)l.get(0)).eat(new Food());
        }
        System.out.println("Demo walk..."+l.size());
    }
//    public void m1 (int a, float b){
//        System.out.println("m1 ");
//    }
    protected  Object  m1 (Object a) {
        System.out.println("Demo::m1 ");
        return null;
    }

    public <J extends Object> void m2 (J a) {
        System.out.println("Demo::m2 ");

    }
}

public class PolymorphismExample extends Demo {
    //    public void walk(Dog d){
//        //d.eat(new Food());
//        System.out.println("Demo child walk...");
//    }
    public static void main(String[] args) {
//        Animal animal = new Animal();
//        animal.eat(new Food());
//
//        Dog dog = new Dog(2, "Danny");
//        dog.eat(new Food());//method overriding
//        dog.eat(3); // method overloading
        Demo demo = new Demo();
        List l = new ArrayList<>();
        l.add(new Dog(2, "lk"));
       // demo.walk(l);
       // demo.walk(new Dog(5, "ronny"));
     }
}
