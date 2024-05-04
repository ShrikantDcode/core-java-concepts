package other;

public class subArrayExample {
    public static void main(String[] args) {
        String str = "abcdefgh";
        char[] chars = str.toCharArray();
        for(int i =0; i< chars.length; i++){
            for(int j =1; j< chars.length; j++) {
                System.out.println((int)chars[i]);
            }
        }
    }
}
