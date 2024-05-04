package designpatterns.singleton;

class Singleton2 {
    static Singleton2 sInstance = null;
    String name;
    private Singleton2(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
//method 1 synchronized method
//    public static synchronized Singleton2 getsInstance() {
//        if (sInstance == null) {
//            sInstance = new Singleton2();
//        }
//        return sInstance;
//    }

    public static Singleton2 getsInstance(String name) {
        if (sInstance == null) { // null check 1
            synchronized (Singleton2.class) {
                if (sInstance == null) { // null check 2 "double checked locking" helps to have more efficient synchronized block
                    sInstance = new Singleton2(name);
                }
            }
        }
        return sInstance;
    }


}

public class SingletonSynchronised {
    public static void main(String[] args) {

        Singleton2 instance1 = Singleton2.getsInstance("Shri");
        System.out.println("instance1 "+instance1.name);
        Singleton2 instance2 = Singleton2.getsInstance("Ramesh");
        System.out.println("instance2 "+instance2.name);
        instance2.setName("Ramesh1");
        System.out.println("instance2 now "+instance2.name);
        if(!(instance1.hashCode() == instance2.hashCode())){
            throw new AssertionError("Singleton pattern failed as were able to create multiple objects.");
        } else {
            System.out.println("Singleton pattern worked as expected");
        }
    }
}
