package streams;

import model.Address;
import model.MobileNumber;
import model.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObjectListProblems {
    public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                25,
                new Address("411037"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                40,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
        Student student4 = new Student(
                "Shrikant",
                25,
                new Address("413512"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        Student student5 = new Student(
                "Shrikant",
                25,
                new Address("413512"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        Set<Student> stdUnique = students.stream().collect(Collectors.toSet());
        System.out.println(stdUnique.size()+" "+stdUnique);
        // Get student with exact match name "jayesh"
        Optional<Student> s1 = students.stream().filter(s -> "jayeshx".equalsIgnoreCase(s.getName())).findFirst();
        System.out.println(s1.isPresent() ? "Student is present" : "Student is not present");
        s1.ifPresent(System.out::println);
        //Get student with matching address "1235"

        Optional<Student> stud1 = students.stream()
                .filter(student -> student.getAddress().getZipcode().equals("1235"))
                .findFirst();
        System.out.println(stud1.isPresent() ? stud1.get().getName() : "No student found");
        System.out.println("-------------------------------------------------------");
        //Get all student having mobile numbers 3333.
         List<Student> l1 = students.stream()
                .filter(student -> student.getMobileNumbers().stream().peek(o -> System.out.println(o.getNumber()))
                        .anyMatch(x -> "3333".equals(x.getNumber())))
                .collect(Collectors.toList());
        System.out.println(l1.toString());
        System.out.println("-------------------------------------------------------");
        //Convert List<Student> to List<String> of student name
        List<String> l2 = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(l2.toString());
        System.out.println("-------------------------------------------------------");
        //Convert List<Student> to String joining
        List<String> l3 = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(l3.stream().collect(Collectors.joining("|","((","))")));
        System.out.println("-------------------------------------------------------");
        System.out.println("--------create seperate lists by age-------------------------");
        Map<Boolean, List<Student>> map = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() < 30));
                //.entrySet()
        map.get(true).stream().map(s -> s.getName())
                .forEach(k -> System.out.println(k));
        System.out.println("--------calculate sum of age using reduce age-------------------------");
        Student s = new Student(
                "xx",
                0,
                new Address("000"),
                Arrays.asList(new MobileNumber("0000"), new MobileNumber("0000")));
        Student news = students.stream()
                .reduce(s, (obj, a) -> new Student(
                        obj.getName()+" | "+a.getName(),
                        obj.getAge()+ a.getAge(),
                        new Address("000"),
                        Arrays.asList(new MobileNumber("0000"), new MobileNumber("0000"))));
        System.out.println(">>> "+news.toString());

        String str = "abbccddee";
        IntStream intStream =  str.chars();
        Stream<String> objStream = intStream.mapToObj(c -> Character.toString((char)c));
       // objStream.forEach(System.out::print);

        IntStream newIntStream = objStream.mapToInt(st -> st.length());
        newIntStream.forEach(System.out::print);
        System.out.println("--------group students by two criteras-------------------------");
        Map<Integer, Map<String, List<Student>>> map2 = students
                .stream()
                .collect(Collectors.groupingBy(Student::getAge,
                        Collectors.groupingBy(std -> std.getAddress().getZipcode())));
        System.out.println(map2.keySet().toString());
        //map2.forEach((k, v)-> v.forEach((k2, v2) -> System.out.println(k+ " : "+k2+ " - "+v2.toString())));



    }
}
