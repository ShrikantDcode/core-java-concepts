package designpatterns.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

enum Singleton {
    INSTANCE;
}
//class Singleton implements Serializable {
//    static Singleton sInstance = new Singleton();
//    private Singleton() {}
//    public static Singleton getsInstance() {
//        return sInstance;
//    }
//
//    protected Object readResolve() {
//        return sInstance;
//    }
//}

public class SingletonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Singleton instance1 = Singleton.getsInstance();
        Singleton instance1 = Singleton.INSTANCE;
        //Singleton instance2 = Singleton.getsInstance();

        //1. way to break singleton pattern using synchronization
//        ObjectOutput out = new ObjectOutputStream(
//                new FileOutputStream("file.text"));
//
//        out.writeObject(instance1);
//        out.close();
//
//        // deserialize from file to object
//        ObjectInput in = new ObjectInputStream(
//                new FileInputStream("file.text"));
//        Singleton instance2
//                = (Singleton)in.readObject();
//        in.close();
        //2. way to break singleton pattern using reflection api
        Singleton instance2 = null;
        try {
            Constructor[] constructors
                    = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton
                // pattern
                constructor.setAccessible(true);
                instance2
                        = (Singleton)constructor.newInstance();
                break;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        if(!(instance1.hashCode() == instance2.hashCode())){
            throw new AssertionError("Singleton pattern failed as were able to create multiple objects.");
        } else {
            System.out.println("Singleton pattern worked as expected");
        }
    }
}
