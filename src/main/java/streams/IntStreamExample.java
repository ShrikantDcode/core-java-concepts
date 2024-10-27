package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
public class IntStreamExample {
    public static void main(String[] args) {
        //create, process and consume pipeline
        IntStream.of(4,2,12,34, 2,1) //create phase]
                .min() // process / intermediate phase
                .ifPresent(System.out::println); // consume/ termination phase
        int max = IntStream.of(4,2,12,34, 2,1)
                .max()
                .getAsInt();
        System.out.println("Max number: "+max);

        //fetch top 3 salaries
        IntStream.of(20000, 12000,22000, 34000, 12000)
                .distinct()
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3).forEach(System.out::println);

        int[] arr = IntStream.of(20000, 12000,22000, 34000, 12000)
                .distinct().boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .toArray();

        //print int values
        int[] a = {2,3,4};
        //IntStream.of(a).forEach(System.out::print);
        Arrays.stream(a).forEach(System.out::print);
    }
}
