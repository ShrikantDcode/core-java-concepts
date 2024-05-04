package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQuestions {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(98,49,10,15,8,49,10,25,32);
        //sort arraylist
        //myList.stream().sorted().forEach(System.out::print);
        //find all numbers starting with 1
        myList.stream()
        .map(n -> n+"")
                .filter(s -> s.startsWith("1")).forEach(System.out::println);
//        //find duplicate numbers in list
//        System.out.println("find duplicate numbers in list ");
//        Set<Integer> set = new HashSet<>();
//        myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);
//        System.out.println("find first duplicate number in list ");
//        myList.stream().filter(n -> !set.add(n)).findFirst().ifPresent(System.out::println);
//        System.out.println("find total numbers of elemets in list using streams ");
//        System.out.println(myList.stream().count());
//        myList.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
//        System.out.println(myList.stream().min(Comparator.naturalOrder()));

        String input = "Java Hungry Blog Alive is Awesome";
        System.out.println("find first non-repeating character in string");
        input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println("concatenate stream ");
        List<Integer> integerList1 = Arrays.asList(1,2,3,4);
        List<Integer> integerList2 = Arrays.asList(5,6,7);
        Stream<Integer> concatStream = Stream.concat(integerList1.stream(), integerList2.stream());
        concatStream.forEach(System.out::println);
        System.out.println("Remove duplicate...i.e show distinct values");
        List<Integer> integerList = Arrays.asList(1,2,3,4,1,2,3);
        //method 1
        integerList.stream().distinct().forEach(System.out::println);
        integerList.stream().collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("Sum "+integerList.stream().mapToInt(Integer::intValue).sum());

    }
}
