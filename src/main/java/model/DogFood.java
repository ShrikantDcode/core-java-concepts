package model;

public class DogFood extends Food{
    public static void main(String[] args) {
        //instanceof example
        Animal a = new Animal();
        Dog d = new Dog(12,"sd");
        String s = new String("a");
        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Object);
        System.out.println(a instanceof Food);
        System.out.println(d instanceof Animal);
        System.out.println(d instanceof Dog);
        System.out.println(s instanceof String);
        System.out.println(Integer.compare(1,2));
    }
}
