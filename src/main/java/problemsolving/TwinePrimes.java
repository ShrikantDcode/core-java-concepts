package problemsolving;

public class TwinePrimes {
    public static void main(String[] args) {
        //print pairs of twine prime numbers in given range n to k
        int n = 2, k = 10000;
        int[] twines = new int[2];
        int t = 0;
        for(int j=n; j<= k; j++){
            if(isPrime(j) == true){
                twines[t++] = j;
                if(twines[0] != 0 && twines[1] != 0){
                    if(twines[1] - twines[0] == 2){
                        System.out.println(twines[0]+" , "+twines[1]);
                        rearrange(twines); t=1;
                    } else {
                        rearrange(twines); t=1;
                    }
                }
            }
        }
    }

    static void rearrange(int[] twines) {
        twines[0] = twines[1];
        twines[1] = 0;
    }

    static boolean isPrime(int num) {
        int divisible = 0;
        for(int i=num-1; i>1; i--){
            if(num%i == 0) {
                divisible++;
                break;
            }
        }
        if(divisible ==0) return true;
        return false;
    }
}
