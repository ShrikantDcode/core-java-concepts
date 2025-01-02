package collections;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionDemo {
    public static void main(String[] args) {
//        The ConcurrentModificationException occurs when a collection is structurally modified
//        while being iterated using an iterator, except through the iterator's own remove method.
//
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Iterating and modifying the map simultaneously
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getKey() == 2) {
                    map.put(4, "Four"); // Structural modification during iteration
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }

        //Solution1: use Iterator's remove method in single-thread scenarios
        for (Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (entry.getKey() == 2) {
                iterator.remove(); // Safe removal
            }
        }
        System.out.println(map);

        //Solution2 : create Object of ConcurrentHashMap instead of HashMap
        Map<Integer, String> map2 = new ConcurrentHashMap<>();
        map2.put(1, "One");
        map2.put(2, "Two");
        map2.put(3, "Three");

        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            if (entry.getKey() == 2) {
                map2.put(4, "Four"); // Safe modification
            }
        }

        System.out.println(map2); // {1=One, 3=Three, 4=Four}

    }
}