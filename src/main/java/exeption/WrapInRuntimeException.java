package exeption;

public class WrapInRuntimeException {
   public static void main(String[] args) {
       WrapInRuntimeException example = new WrapInRuntimeException();
        example.callingMethod();
    }

    public void callingMethod() {
        try {
            methodThatThrowsException();
        } catch (Exception e) {
            throw new RuntimeException("Wrapped exception: " + e.getMessage(), e);
        }
    }

    public void methodThatThrowsException() throws Exception {
        throw new Exception("This is a checked exception");
    }
}
