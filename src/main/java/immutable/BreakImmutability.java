package immutable;

import java.lang.reflect.Field;

class MyAddress {
    String line1;

    public MyAddress(String line1) {
        this.line1 = line1;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                '}';
    }
}

//Immutable class
final class MyUser implements Cloneable{
    private final int id;
    private final String name;
    private final MyAddress address;

    public MyUser(int id, String name, MyAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
        //create deep copy to avoid modification on original address reference
        //this.address = new MyAddress(address.getLine1());
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MyAddress getAddress() {
        return address;
    }

    //shallow copying by default -> modifying cloned object will modify original object also
//    @Override
//    public MyUser clone() throws CloneNotSupportedException {
//        return (MyUser) super.clone();
//    }

    //deep copy to avoid immutability break -> modifying cloned object will NOT modify original object
    @Override
    public MyUser clone() throws CloneNotSupportedException {
        MyUser clonedUserObj =  (MyUser) super.clone();
        MyAddress newAddressObj = new MyAddress(this.getAddress().getLine1());
        return new MyUser(clonedUserObj.getId(), clonedUserObj.getName(), newAddressObj);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class BreakImmutability {

    public static void main(String[] args) throws CloneNotSupportedException, NoSuchFieldException, IllegalAccessException {

        MyAddress myAddress = new MyAddress("gangadham phase2");
        MyUser user =  new MyUser(1, "Shri", myAddress);


        System.out.println("before : "+user.getAddress().getLine1()+" - "+user.getId());
        myAddress.setLine1("Mgarpatta"); //modified original address ref
        System.out.println("after : "+user.getAddress().getLine1()+" - "+user.getId());
        // due to deep copy line1 changes doesn't happen in reference set in MyUser

        //Lets try ways to break immutability
        //1. Through exposed object reference (modify original address object after passing it to MyUser constructor)
        //2. cloning and then modifying
        //3. Reflection API (do field.setAccesible(true) and then update value for that field
        //4. get object reference by deserializing object from file

        MyUser duplicateUser = user.clone();

        duplicateUser.getAddress().setLine1("Singapor");
        System.out.println("after cloning original: "+user.getAddress().getLine1()+" - "+user.getId());
        System.out.println("after cloning cloned: "+duplicateUser.getAddress().getLine1()+" - "+duplicateUser.getId());

        breakWithReflectionAPI();
    }

    public static void breakWithReflectionAPI() throws IllegalAccessException, NoSuchFieldException {
        MyUser immutableObject = new MyUser(3,"Original", null);
        Field field = MyUser.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(immutableObject, "Modified");

        System.out.println("user after modification :"+immutableObject.toString());
    }
}
