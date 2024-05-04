package streams;

public class StreamReduceExample {
    public static void main(String[] args) {
        String str="aabcccabbbbc";
        StringBuilder result = str.chars()
                .mapToObj(c -> (char)c)
                .reduce(new StringBuilder(),
                        (sb, ch) -> sb.length() > 0 && sb.charAt(sb.length() -2) == ch
                            ? sb.replace(sb.length() -1, sb.length(), String.valueOf(Character.getNumericValue(sb.charAt(sb.length() -1)) + 1))
                            : sb.append(ch).append(1), StringBuilder::append);
        System.out.println(result);
    }
}
