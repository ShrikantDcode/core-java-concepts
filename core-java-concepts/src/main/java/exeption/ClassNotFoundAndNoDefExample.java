package exeption;

class Test {
    public void hello() {
        System.out.println("hello");
    }
}

class Demo {
    static int data = 1 / 0;
}

public class ClassNotFoundAndNoDefExample {
    public Demo getDemo() {
        Demo test;
        try {
            test = new Demo();
        } catch (Throwable t) {
            System.out.println(t);
        }
        test = new Demo();
        return test;
    }

    public static void main(String[] args) {

        try {
            Test t = (Test) Class.forName("main.java.exception.Test").newInstance();
            //Test t = ClassLoader.findSystemCLass("main.java.exception.Test").newInstance();
            t.hello();
        } catch (ClassNotFoundException e) {
            System.out.println("Checked exception...");
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        ClassNotFoundAndNoDefExample sample
                = new ClassNotFoundAndNoDefExample();
        sample.getDemo();

    }
}
