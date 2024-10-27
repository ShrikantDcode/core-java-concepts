package collections;

import model.Person;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person(20, "Mahesh"), "moon");
        map.put(new Person(40, "Suresh"), "xyz");
        map.put(new Person(20, "Mahesh"), "earth");

        map.entrySet().forEach(System.out::println);
        System.out.println("=> "+map.get(new Person(20, "Mahesh")));
        for(Map.Entry entry: map.entrySet()){
            System.out.println(entry.getValue());
        }


    }
}
