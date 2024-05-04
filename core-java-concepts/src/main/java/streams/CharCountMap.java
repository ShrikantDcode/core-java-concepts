package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CharCountMap {
    static void showTotalCount(String str){
        Map<Character, Long> map = new HashMap<>();
        str.chars().forEach(c -> {
            if(map.get((char)c) != null) {
                map.put((char) c, map.get((char)c)+1);
            } else {
                map.put((char) c, 1L);
            }
        });
        System.out.println(">> "+map.toString());
    }

    static void showCountSequence(String str) {
        Map<Character, Long> map = new HashMap<>();
        //char current;
        str.chars().forEach(c -> {
            //System.out.println(map.toString()+" - "+map.get((char)c));
            char current = (char) c;
            if(map.get((char)c) == null) {
                map.put(current, 0L);
                map.put((char) c, 1L);
            } else {
                map.put((char) c, map.get((char)c)+1);
            }
        });
        System.out.println(">> "+map.toString());
    }
    static void showCountSequence1(String str) {

        StringBuilder reduce = str.chars().mapToObj(c -> (char) c)
                                    .reduce(new StringBuilder(),
                                            (sb, c) -> sb.length() > 0 && sb.charAt(sb.length() - 2) == c
                                                    ? sb.replace(sb.length() - 1, sb.length() , String.valueOf(Character.getNumericValue(sb.charAt(sb.length() - 1)) + 1))
                                        : sb.append(c).append(1), StringBuilder::append);

        System.out.println(reduce);
    }
    public static void main(String[] args) {
        String str="abbcccabc";
        //showTotalCount(str);
        //showCountSequence(str);
        showCountSequence1(str);

    }
}
