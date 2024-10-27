package model;

import java.util.Objects;

public class Person {
    private int age;
    public String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void eat(int numberOfTimes) {
        System.out.println("...person eats "+numberOfTimes);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
        //return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
        //return  1;
    }
}
