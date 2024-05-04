package core;

import java.util.Arrays;

public class ArraysUtilsDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 12, 0, 20, 2, 22, 10, 11, 12, 13, 14,};
        int[] copied = Arrays.copyOf(arr, arr.length);
        Arrays.fill(arr, arr.length -3, arr.length, 1000);

        for(int i: arr)
            System.out.println(i);
        for(int i: copied)
            System.out.println(">> "+i);
    }
}
