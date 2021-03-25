package exceptions;

public class NotOverridenException extends RuntimeException {
    public NotOverridenException(String msg) {
        super(msg);
    }
}
