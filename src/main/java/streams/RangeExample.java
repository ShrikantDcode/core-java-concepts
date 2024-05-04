package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class RangeExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3,4,6,2,9);
        List<Integer> missingNumbers = new ArrayList<>(); //5,7,8
        IntStream numbers = IntStream.rangeClosed(2, 9);
         numbers//.boxed().sorted().collect(Collectors.toList());
        .forEach(e -> {
            if(!list1.contains(e)) {
                missingNumbers.add(e);
            }
        });
        System.out.println(missingNumbers);
        // calculate total using reduce
        double total = DoubleStream.of(0.1, 2.3, 5.3)
                .reduce(10.1, (double d1, double d2) -> d1+d2);
        System.out.println("total :"+total);

        String s ="PM";
        System.out.println(s.contains("PM"));
    }
}
