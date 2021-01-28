package hu.uni.eku.tzs.service.exceptions;

public class WatchAlreadyExistException extends Exception{

    public WatchAlreadyExistException() {
    }

    public WatchAlreadyExistException(String message) {
        super(message);
    }

    public WatchAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public WatchAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
