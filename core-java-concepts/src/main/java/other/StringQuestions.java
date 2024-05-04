package other;

import java.util.Arrays;

public class StringQuestions {
    public static void main(String[] args) {
        //printDuplicateChars("Java");
        checkIfStringsAreAnargmas("jakva","avajj");
    }
    public static void printDuplicateChars(String s){
        char[] chars = s.toCharArray();
        for(int i=0;  i< s.length(); i++){
            if(i != s.indexOf(chars[i]))
                System.out.println(chars[i]);
        }
    }

    public static void checkIfStringsAreAnargmas(String a, String b){
        if(a.length() != b.length())
            System.out.println("length is different: NOT anargms strings");

        char[] chars1 = a.toCharArray();
        Arrays.sort(chars1);
        String a2 = new String(chars1);
        System.out.println(" strings1 "+a2);

        char[] chars = b.toCharArray();
        Arrays.sort(chars);
        String b2 = new String(chars);
        System.out.println(" strings2 "+b2);
        if(a2.equals(b2)){
            System.out.println("Yes, these are anargms strings");
        } else {
            System.out.println("NOT anargms strings");
        }

    }
}
