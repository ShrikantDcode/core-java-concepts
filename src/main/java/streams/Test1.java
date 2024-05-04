package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        String strSentence = " Hi EPAM bye EPAM goodbye EPAM welcome ePAM Hi There epAM bye bye EPaM";
        getWordCount(strSentence);
    }

    String strSentence = " Hi EPAM bye EPAM goodbye EPAM welcome ePAM Hi There epAM bye bye EPaM";

    static void getWordCount(String str) {

        String[] arr = str.split(" ");
        LinkedHashMap<String, Long> map =
                Arrays.asList(arr).stream()
                        .map(s -> s.toUpperCase())
                        .filter(w -> "BYE".equals(w) || "EPAM".equals(w) ||"HI".equals(w))
                        .collect(Collectors.groupingBy(i ->i, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(map);
    }
}