package concurrency;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ab");
        map.put(3, "cd");

        map1.put(5, "ll");
        map.entrySet().forEach(v -> map.put(4, "xy"));
        System.out.println(map);
    }
}
