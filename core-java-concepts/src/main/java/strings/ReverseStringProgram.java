package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseStringProgram {

    public static void main(String[] args) {
        String str = "WelcomeToJava";
        String rev ="";
        char temp = '\u0000';

        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            rev = temp+rev; // similar to add first of Deque
        }

        System.out.println("Reversed string: "+ rev);
    }
}
