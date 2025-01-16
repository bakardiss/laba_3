package exception;
import java.lang.Exception;
import interfaces.*;
public class FlightException extends Exception {
    public FlightException(String message) {
        super(message);
    }
}