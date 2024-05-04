package designpatterns.singleton;

class Singleton3 implements Cloneable{

    private Singleton3(){}
    static class SingletonBuilder {
        static Singleton3 sInstance = new Singleton3();
    }

    public static Singleton3 getsInstance() {
        return SingletonBuilder.sInstance;
    }
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}

public class SingletonInnerClass {
    public static void main(String[] args) throws CloneNotSupportedException {

        Singleton3 instance1 = Singleton3.getsInstance();
        Singleton3 instance2 = Singleton3.getsInstance();
        //way to break singleton pattern using deep copy
        //Singleton3 instance2 = (Singleton3) Singleton3.getsInstance().clone();

        if(!(instance1.hashCode() == instance2.hashCode())){
            throw new AssertionError("Singleton pattern failed as were able to create multiple objects.");
        } else {
            System.out.println("Singleton pattern worked as expected, both refer to same object");
        }
    }
}
