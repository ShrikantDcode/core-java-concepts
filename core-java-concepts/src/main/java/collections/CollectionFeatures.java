package collections;

import java.util.*;

public class CollectionFeatures {
    public static void main(String[] args) {
        HashSet<String> days = new HashSet<>();
        days.add("monday");
        days.add("sunday");
        days.add(null);
        days.add("monday");
        days.add("Wedensday");
        days.add(null);
        System.out.println(days);

        Iterator<String> itr = days.iterator();
        itr.forEachRemaining(System.out::println);
        //System.out.println(days.size());
        //1. Hashset an unordered collection, doesn't maintain any order
        //2. internally adds data as keys in the hashmap with value PRESENT

        ArrayList<String> daysl = new ArrayList<>();
        daysl.add("monday");
        daysl.add("sunday");
        daysl.add("monday");
        daysl.add("Wedensday");

        ArrayList<String> daysl2 = new ArrayList<>();
        daysl2.add("monday-x");
        daysl2.add("monday-y");

        daysl.addAll(daysl2);
        //daysl.remove(4);

        System.out.println(daysl);
        System.out.println(daysl.subList(1, 4));
        //1. Arraylist is an ordered collection, maintains insertion order

        TreeSet<String> ts = new TreeSet<>();
        // ts.add(null); // TreeSet doesn't allow null value
        ts.add("sun");
        ts.add("wed");
        ts.add("mon");
        System.out.println(ts);

//        TreeSet<Employee> ts2 = new TreeSet<>(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                    return o1.age - o2.age;
//            }
//        });
        //TreeSet<Employee> ts2 = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("===========================================================================");
        TreeSet<Employee> ts2 = new TreeSet<>(Comparator.comparing(Employee::getAge));
        ts2.add(new Employee(98));
        ts2.add(new Employee(34));
        ts2.add(new Employee(20));
        ts2.add(new Employee(50));
        System.out.println(ts2);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("ABC", 20);
        hm.put("AB", 1);
        hm.put("BC", 10);
        hm.put("C", 2);
        hm.forEach((k, v) -> System.out.println(k+">"+v));
        hm.remove("AB", 2);
        System.out.println(hm);
        hm.remove("AB");
        hm.replace("ABC", 20, 40);
        hm.replace("ABC", 10, 50);
        hm.compute("C",(k, v) -> Integer.valueOf(k.length()+v));
        hm.computeIfAbsent("X",v -> 100); // k, Function
        hm.computeIfPresent("BC", (k, v) -> Integer.valueOf(v*3) ); //k, BiFunction
        System.out.println(hm);
        hm.replaceAll((k ,v) -> 200);


        LinkedList<Integer> ls = new LinkedList<>();
        ls.contains(3);


    }
}

class Employee {
    int age;

    public Employee(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public int compareTo(Object o) {
//        Employee emp = (Employee) o;
//        return this.age - emp.age;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                '}';
    }
}