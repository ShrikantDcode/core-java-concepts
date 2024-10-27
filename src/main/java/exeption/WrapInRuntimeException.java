package exeption;

public class WrapInRuntimeException {
   public static void main(String[] args) {
       WrapInRuntimeException example = new WrapInRuntimeException();
        example.callingMethod();
    }

    public void callingMethod() {
        try {
            methodThatThrowsException(); //checked exception thrown
        } catch (Exception e) {
            //checked exception caught and converted to RuntimeException to stop exception propagation to main method
            // now main method doesn't have to handle or declare this exception
            throw new RuntimeException("Wrapped exception: " + e.getMessage(), e);
        }
    }

    public void methodThatThrowsException() throws Exception {
        throw new Exception("This is a checked exception");
    }
}
