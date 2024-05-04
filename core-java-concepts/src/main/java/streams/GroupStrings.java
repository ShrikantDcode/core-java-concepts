package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc","pqr","abcd","pqrs","ab","pq");
        List res = list.stream()
                .collect(Collectors.groupingBy(s -> s.length()))
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());//.forEach(System.out::println);
        for(Object s: res) {
            System.out.println(s);
        }
    }
}
