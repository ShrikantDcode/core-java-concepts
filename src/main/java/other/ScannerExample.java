package other;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            System.out.println(scan.next());
        }
        //System.out.println(scan.nextLine());
        System.out.println(scan.nextInt());
        System.out.println(scan.nextDouble());
        scan.close();
    }
}
