package immutable;

class Address {
    String line1;

    public Address(String line1) {
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
final class User {
    private final int id;
    private final String name;
    private final Address address;

    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        //this.address = address;
        //create deep copy
        Address clonedAdd = new Address(address.getLine1());
        this.address = clonedAdd;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
public class ImmutableExample {

    public static void main(String[] args) {

        Address add = new Address("kalepadal");
        User user1 =  new User(1, "Shri", add);

        System.out.println("User : "+user1.getAddress());
        add.setLine1("Viman nagar"); // using old reference
        System.out.println("User now: "+user1.getAddress());
        System.out.println("original Object references : "+add.hashCode() +" new object reference "+user1.getAddress().hashCode());

        Address add2 = new Address("Kharadi");
        User user2 =  new User(2, "Ramesh", add2);
        System.out.println("User2 : "+user2.getAddress()+" > "+user2.getId());
    }
}
