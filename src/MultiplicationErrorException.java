public class MultiplicationErrorException extends Exception {
    public MultiplicationErrorException() {
        super("Multiplikation nicht möglich!");
    }

    public MultiplicationErrorException(String fehler) {
        super(fehler);
    }
}