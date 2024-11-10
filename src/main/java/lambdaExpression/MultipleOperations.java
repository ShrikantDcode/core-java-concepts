package lambdaExpression;
import java.io.*;
import java.util.*;

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation isOdd(){
        PerformOperation pop = (num) -> num % 2 != 0;
        return pop;
    }

    public PerformOperation isPrime(){
        PerformOperation pop = (num) -> {
            for(int i=2; i < num; i++){
                if(num % i == 0){
                    return false;
                }

            }
            return true;
        };
        return pop;
    }

    public PerformOperation isPalindrome(){
        PerformOperation pop = (num) -> {
            String input = String.valueOf(num);
            char text1[] = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = text1.length - 1; i >= 0; i--) {
                sb.append(text1[i]);
            }

            return sb.toString().equals(input);
        };
        return pop;
    }

}

public class MultipleOperations {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
