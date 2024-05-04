package strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SubstringSorting {

    public static void main(String[] args) {
        //char array to string object
        char char_arr[] = {'G', 'e', 'e', 'k', 's'};
        String str1 = new String(char_arr); //Geeks
        String str = "welcometojava";
        SubString(str, str.length());
    }
    public static void SubString(String str, int n)
    {
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        System.out.println(str);
        int end = 3;
        for (int i = 0; i < n; i++) {
            String s = str.substring(i, end);
                end++;
                if(s.length() == 3) {
                    list.add(s);
                    break;
                }
        }
        List<String> s1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("first :"+s1.get(0));
        System.out.println(">"+s1);
        //String s2 = list.stream().sorted(Comparator.reverseOrder()).limit(1).flatMap(Stream::of).toString();
        System.out.println("last :"+s1.get(list.size()-1));
    }
}
