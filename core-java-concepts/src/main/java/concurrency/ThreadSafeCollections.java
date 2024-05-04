package concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCollections {

    public static void randomReadAndWriteSynchronizedMap() {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<String, Integer>());
        performReadAndWriteTest(map);
    }

    public static void randomReadAndWriteConcurrentHashMap() {
        Map<String, Integer> map = new HashMap<>();
        performReadAndWriteTest(map);
    }

    private static void performReadAndWriteTest(final Map<String, Integer> map) {
        int TEST_NO_ITEMS = 100;
        for (int i = 0; i < TEST_NO_ITEMS; i++) {
            Integer randNumber = (int) Math.ceil(Math.random() * TEST_NO_ITEMS);
            map.get(String.valueOf(randNumber));
            map.put(String.valueOf(randNumber), randNumber);
            if(i== 44)
            map.remove(new Integer(44));
        }
        System.out.println("map : "+map);
    }
    public static void main(String[] args) {
        randomReadAndWriteConcurrentHashMap();
        //randomReadAndWriteSynchronizedMap();
    }
}
