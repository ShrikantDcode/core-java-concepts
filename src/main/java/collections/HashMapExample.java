package collections;

import model.Person;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person(20, "Mahesh"), "moon");
        map.put(new Person(40, "Suresh"), "xyz");
        map.put(new Person(20, "Mahesh"), "earth");

        map.forEach((k, v) -> {
            if(k.getAge() == 20){
                k.setName("xxxx");
                System.out.println(k);
            } else {
                System.out.println(k);
            }});
    }
}
