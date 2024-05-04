package typeconversion;

public class TypeConversionExamples {

    static void typeCasting(){
        //manual type casting of compatible types
        int i = 12;
        short f = (short) i;
        byte b = (byte) f;
        char c = 'a';
        byte c1 = (byte) c;

    }
    static void typeConversion(){
        //automatic type conversion of compatible types
        int i = 12;
        float f1 = i;
        double d1 = i;
        char cc = 'a';
        byte b11 = 111;
        short s2 = b11;
        //System.out.println(i+" "+f1+" "+s2+" "+cc+" "+b11);
        int a = 10;
        String s = String.valueOf(a);
        //long l = 20;
        Long l = new Long(40);
        String ls = String.valueOf(l);
        double dd = 20.2;
        String dds = String.valueOf(dd);
        short c2 = 'b';
        String c2s = String.valueOf(c2);
        String s1 = "15s";
        int i1 = Integer.valueOf(s1);
        long l1 = Long.valueOf(s1);
        float f = Float.valueOf(s1);
        double d = Double.valueOf(s1);
        System.out.println(ls+" "+dds+" "+c2s+" "+f);
    }
    public static void main(String[] args) {

        typeConversion();

        //Autoboxing and unboxing
        int a1 = 10;
        Integer a1Auto = a1;
        int b1 = (int)a1;
        System.out.println(a1Auto+" "+b1);

    }
}
