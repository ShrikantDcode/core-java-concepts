package problemsolving;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingNumber {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(20, 1, 2, 10, 20, 1, 3, 2, 5);
        int[] arr = {20, 1, 2, 10, 20, 1, 3, 2, 5};
        //findFirstNonRepeatingNumber(arr);
        findFirstNonRepeatingNumber2(arr);
        //findFirstNonRepeatingUsingStreams(arr);
    }
    static void findFirstNonRepeatingNumber(int[] arr) {
        for(int i=0; i< arr.length; i++){
            int j = 0;
            for(j =0; j < arr.length; j++) {
                System.out.println(arr[i] +" > "+arr[j]);
                if (i != j && arr[i] == arr[j])
                    break;
            }
                if(j == arr.length) {
                    System.out.println("non-repeating number "+arr[i]);
                    break;
                }
        }

    }

    static void findFirstNonRepeatingNumber2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++){
//            if(map.containsKey(arr[i])) {
//                map.put(arr[i], map.get(arr[i]) +1);
//            } else {
//                map.put(arr[i], 1);
//            }
            //java8 way to write a consice code
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        for(int i=0; i< arr.length; i++) {
            if(map.get(arr[i]) == 1) {
                System.out.println("first non-repeating number is:" + arr[i]);
                break;
            }
        }
        //System.out.println(map);
    }

    static void findFirstNonRepeatingNumber3(int[] arr) {
        List<Integer> list = new LinkedList<>();
        for(int i=0; i< arr.length; i++){
            if(list.contains(arr[i])) {
                list.remove(list.indexOf(arr[i]));
            } else {
                list.add(arr[i]);
            }
        }
        System.out.println("first non-repeating number is:"+list.get(0));
    }
    static void findFirstNonRepeatingUsingStreams(int[] arr){
        List<Integer> list = Arrays.asList(20, 1, 2, 10, 20, 1, 3, 2, 5);

        Optional<Integer> result = list.stream()
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                //.sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .findFirst();

        if (result.isPresent()) {
            System.out.println("First non-repeating number: " + result.get());
        } else {
            System.out.println("No non-repeating number found.");
        }
    }
}
