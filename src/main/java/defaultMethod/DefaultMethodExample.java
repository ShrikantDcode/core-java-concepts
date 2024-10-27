package defaultMethod;

interface MyFunctionalInterface <T>{
    public static void sayHello() {
        System.out.println("Hi I am static method of interface");
    }
    public void doSomething(T t);

    default void doSomethingExtra(T t) {
        System.out.println("default method doSomethingExtra...called from "+t);
    }
}
interface A {
    public void m1();
}

abstract class ClassA implements A {
    public void m1() {
        System.out.println("inside ClassA::m1");
    }
}
public class DefaultMethodExample extends ClassA {
    public static void main(String[] args) {
        MyFunctionalInterface<String> myFunctionalInterface = (s) -> System.out.println("this is me doing something :"+s);
        myFunctionalInterface.doSomething("Shri"); //calling only abstract method of an interface

        myFunctionalInterface.doSomethingExtra("interface reference");

        MyImplementation obj = new MyImplementation();
        obj.doSomethingExtra("implementation class object");

        MyFunctionalInterface.sayHello(); //calling static method of an interface
        DefaultMethodExample d = new DefaultMethodExample();
        d.m1();
    }
}

class MyImplementation<T> implements MyFunctionalInterface<T> {

    @Override
    public void doSomething(T t) {
        System.out.println("doSomething...implementation by DefaultMethodExample class" );
    }
    @Override
    public void doSomethingExtra(T t) {
        System.out.println("ovverridden default method");
    }


}
