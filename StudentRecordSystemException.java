/**
 * StudentRecordSystemException is a custom exception class that extends the
 * RuntimeException class. It is used to handle exceptions that occur in the
 * StudentRecordSystem class.
 * 
 * @see StudentRecordSystem
 * @see RuntimeException
 */
public class StudentRecordSystemException extends RuntimeException {

    /**
     * Constructs a StudentRecordSystemException object
     */
    public StudentRecordSystemException() {
        super();
    }

    /**
     * Constructs a StudentRecordSystemException object with the specified
     * message.
     * @param message The message of the exception.
     */
    public StudentRecordSystemException(String message) {
        super(message);
    }

}
