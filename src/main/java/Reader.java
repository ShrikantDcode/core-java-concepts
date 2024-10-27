import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reader {
    static List<String> getStrings(String file1) throws IOException {
        File file = new File(file1);
        List<String> strings;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            strings = reader.lines().filter(Reader::isValid).collect(Collectors.toList());
        }
        return strings;
    }

    private static boolean isValid(String line) {
        Pattern p = Pattern.compile("[A-Za-z]");
        Matcher matcher = p.matcher(line);
        boolean has3Groups = matcher.groupCount() == 3;
        boolean matches = matcher.find();
        if (matches && has3Groups) {
            String city = matcher.group("city");
            String state = matcher.group("state");
            String area = matcher.group("area");
            return true;
        }
        return  false;
    }
}
