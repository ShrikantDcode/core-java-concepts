package strings;

import java.util.concurrent.atomic.AtomicInteger;

final class Car {
    String name;
    Car(String name) {
        this.name = name;
    }
    public static String join(String a, String b){
        return new String("join :"+a+b);
    }
    public String concat(String a) {
        return new String("concat :"+this.name+a);
    }
}

public class StringOperations {

    public static void main(String[] args) {

        String str = "Hello";
        System.out.println(String.join("","a","b","c"));
        System.out.println(str.concat("x"));
        Car car = new Car("bmw");
        System.out.println(car.concat("UUU"));
        System.out.println(Car.join("x","y"));
        System.out.println(str.indexOf('e'));
        System.out.println(str.indexOf('e', 1));
        int n1 = 47;
        float n2 = 35.864f;
        double n3 = 44534345.7643434343d;
        String str1 = "Jhon";
        int age = 34, sal = 25000000;
        // format as number
        System.out.println(String.format("|%d|", n1));
        System.out.println(String.format("|%04d|", n1));
        System.out.println(String.format("|%.16f|", n2));
        System.out.println(String.format("|%,.2f|", n3));
        System.out.println(String.format("|%s's age is %05d his salary is %,d|", str1, age, sal));


    }
}

