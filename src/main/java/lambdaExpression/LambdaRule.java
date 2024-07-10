package lambdaExpression;

public class LambdaRule {

    public static void main(String[] args) {
        // #1. effectively final variable
        int num = 10;
        // Lambda expression
        Runnable r = () -> {
            System.out.println("Number is: " + num);
        };
        r.run();

        // Uncommenting the below line will cause a compilation error
         //num = 20;

        // #2. final variable
        final int num2 = 10;
        // Lambda expression
        Runnable r2 = () -> {
            System.out.println("Number is: " + num2);
        };
        r.run();

        // can not assign value to a final variable
        //num = 20;
    }
}
