package exceptions;

public class RecursionException extends RuntimeException {
    public RecursionException() {}
    public RecursionException(String msg) {
        super(msg);
    }
}
