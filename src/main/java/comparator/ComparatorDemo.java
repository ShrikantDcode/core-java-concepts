package comparator;

import model.Dog;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
       List<Dog> dogs = new ArrayList<>(Arrays.asList(
               new Dog(2, "buddy"),
               new Dog(1, "tommy"),
               new Dog(4, "johnny")));

//     Comparator<Dog> c1 = (d1, d2) -> d1.getAge() < d2.getAge() ? -1
//                                        : (d1.getAge() > d2.getAge() ? 1 : 0);
       Comparator<Dog> c0 = new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                return Integer.compare(d1.getAge(), d2.getAge());
            }
        };
        Comparator<Dog> c2 = (d1, d2) -> Integer.compare(d1.getAge(), d2.getAge());
        Comparator<Dog> c3 = Comparator.comparingInt(Dog::getAge);
        dogs.sort(c2);
        //Collections.sort(dogs, c2);
        dogs.forEach(System.out::println);

        System.out.println("-----------------------------------------");
        dogs.stream().sorted(Comparator.comparingInt(Dog::getAge)
                        .thenComparing(Dog::getName))
                         .forEach(System.out::println);


    }
}
