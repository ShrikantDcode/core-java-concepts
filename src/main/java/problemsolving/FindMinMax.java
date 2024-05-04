package problemsolving;

import java.util.Arrays;

public class FindMinMax {
    public static void main(String[] args) {
        int[] numbers = {4,1, 12, 34, 2, -1};
        findMinimum(numbers);
        findMax(numbers);
        //using stream api
        int max  = Arrays.stream(numbers).max().getAsInt();
        System.out.println(" max by stream "+max);

    }

    static void findMax(int[] numbers){
        //1. assign first element as max
        int tempMax = numbers[0];
        //2. loop through second element to last element (length -1) of array
        for(int i=1; i< numbers.length; i++){
            //3. check if ith element is greater than tempMax if yes assign ith element to tempMax 
            if(numbers[i] > tempMax){
                tempMax = numbers[i];
            }
        }
        System.out.println("Maximum number is "+tempMax);
    }

    static void findMinimum(int[] numbers){
        int tempMin = numbers[0];
        for(int i=1; i< numbers.length; i++){
            if(numbers[i] < tempMin){
                tempMin = numbers[i];
            }
        }
        System.out.println("Minimum number is "+tempMin);
    }
}
