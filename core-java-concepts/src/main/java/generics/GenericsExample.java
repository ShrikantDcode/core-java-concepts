package generics;

import model.Animal;
import model.Cat;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample <T> {
    public static void main(String[] args) {
        Printer<Integer> printer1 = new Printer<>(23);
        printer1.print();

        Printer<String> printer2 = new Printer<>("Hi");
        printer2.print();

        List<Integer> intList = new ArrayList<>();
        intList.add(23);
        intList.add(10);
       // printList(intList);
        printAnyting(intList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat(1, "sam"));
        catList.add(new Cat(3, "nancy"));
        printOnlyAnimals(catList);
        printAnyting(catList);
    }

    public static void printOnlyAnimals(List<? extends Animal> myList) {
        System.out.println(myList);
    }
    //method definition with generic type parameter
    public static <T> void printAnyting(List<T> myList) {
        System.out.println(">> "+myList);
    }

    //metod definition with generic return type <T> declared at class level

    public T m1(){
        return null;
    }
    public <K> K m2 (int a){
        System.out.println("m2 ");
        return null;
    }
    public <J extends Object> J m3 (int a){
        System.out.println("m3 ");
        return null;
    }
}
