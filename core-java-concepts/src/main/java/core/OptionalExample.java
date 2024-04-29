package core;

import model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Cat> myCat = findByName("Stecy");

        //Right way
        Integer age = myCat.map(Cat::getAge)
                .orElse(0);
        System.out.println(">>> "+age);
        Optional<Integer> optionalAge = myCat.map(Cat::getAge);
        System.out.println("> "+optionalAge);

        //wrong way
//        if(myCat.isPresent()) {
//            System.out.println(myCat.get().getAge());
//        } else {
//            System.out.println(0);
//        }
        //------------------------------------------------
        List<Optional<Employee>> l = new ArrayList<>();
        l.add(Optional.empty());
        System.out.println(l.get(0).map(Employee::getName).orElse("Jhon"));
    }

    public static Optional<Cat> findByName(String name) {
        Cat cat = new Cat(3, name);
        return Optional.ofNullable(null);
    }
}
