package exceptions;

public class NotOverriddenException extends RuntimeException {
    public NotOverriddenException(String msg) {
        super(msg);
    }
}
