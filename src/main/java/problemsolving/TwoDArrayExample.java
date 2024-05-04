package problemsolving;

import java.util.stream.IntStream;

public class TwoDArrayExample {
    public static void main(String[] args) {
//        1 1 1 0 0 0
//        0 1 0 0 0 0
//        1 1 1 0 0 0
//        0 0 2 4 4 0
//        0 0 0 2 0 0
//        0 0 1 2 4 0
        int[][] a = {{1,1,1,0,0,0}, {0,1,0,0,0,0}, {1,1,1,0,0,0}, {0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
        //           {{(0,0), (0,1), (0,2), (0,3), (0,4), (0,5)},
        //              {{(1,0), (1,1), (1,2), (1,3), (1,4), (1,5)}
        int sum = 0, hourglass = 0;
        for(int i = 0; i<4 ; i++){
            for(int j = 1; j<5 ; j++){
                System.out.print(a[i][j] +" "); //  row data
                sum = a[i][j-1] +a[i][j] + a[i][j+1]
                                 +a[i+1][j]
                       +a[i+2][j-1] +a[i+2][j] +a[i+2][j+1];
                if(i == 0 && j == 0) hourglass = sum;
                if(sum > hourglass)
                    hourglass = sum;
            }
            System.out.println("Sum :"+sum);
        }
        System.out.println("==========================================hourglass="+hourglass);
        //calcHourglassSumJava8(arr);
    }

    static void calcHourglassSumJava8(int[][] arr) {
        IntStream.range(0 ,6).forEach(i -> {
            IntStream.range(0 ,6).forEach(j -> {
                System.out.print(arr[i][j] +" "); //  row data
            });
            System.out.println();
        });
    }
}
