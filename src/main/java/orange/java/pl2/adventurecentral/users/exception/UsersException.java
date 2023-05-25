package orange.java.pl2.adventurecentral.users.exception;

public class UsersException extends Exception {
        static final long serialVersionUID = 2231374811123530132L;

    public UsersException() {
        }

    public UsersException(String message) {
            super(message);
        }

    public UsersException(String message, Throwable cause) {
            super(message, cause);
        }

    public UsersException(Throwable cause) {
            super(cause);
        }
}
