package problemsolving;

import java.util.*;

public class StackExample {
    public static void main(String[] args) {
//        input-([{}])  output-Balanced parenthis
//        input-[]{{]]  output-unBalanced parenthis
        String ps = "([{{{{}]}}})";
        char[] paras = ps.toCharArray();
        System.out.println(areBracketsBalanced(paras));
    }

    static boolean areBracketsBalanced(char[] paras) {
        Deque<Character> stack = new ArrayDeque<>();

        //int[] arr = new int[ps.length()];
        for (char p : paras) {

            if (p == '(' || p == '[' || p == '{') {
                stack.push(p);
                continue;
            }
            char check;
            switch (p) {
                case ')':
                    check = stack.pop(); //or removeFirst
                    if (check == '}' || check == ']') return false;
                    break;
                case '}':
                    check = stack.pop(); //or removeFirst
                    if (check == ')' || check == ']') return false;
                    break;
                case ']':
                    check = stack.pop(); //or removeFirst
                    if (check == '}' || check == ')') return false;
                    break;
            }
            System.out.println(stack);
        }
        return stack.isEmpty();
    }
}
