package collections;

import java.time.LocalDateTime;
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        LocalDateTime timeStart = LocalDateTime.now();
        System.out.println("time start : "+timeStart);
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vectorList = new Vector<>();

        Set<Integer> hSet = new HashSet<>();
        Set<Integer> tSet = new TreeSet<>();
        Set<Integer> lhSet = new LinkedHashSet<>();

    }
}
