package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTextExample {
    public static void main(String[] args) throws IOException {
        Stream<String> rows = Files.lines(Paths.get("data.csv"));
            Map<String, String> map = rows.map(txt -> txt.split(","))
                    .filter(x -> x.length == 3)
                    .collect(Collectors.toMap(x -> x[0], x -> "XX"));

        Iterator itr =  map.entrySet().iterator();
        while(itr.hasNext())
                System.out.println(itr.next());
//        for(Map.Entry<String, String> e : map.entrySet())
//            System.out.println(e);
        rows.close();
    }
}
