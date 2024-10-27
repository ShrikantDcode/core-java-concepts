import java.io.IOException;
import java.util.List;


public class IntellijTricks {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello there");
        List<String> strings = Reader.getStrings("lines.txt");

        System.out.println(strings);
    }

}
