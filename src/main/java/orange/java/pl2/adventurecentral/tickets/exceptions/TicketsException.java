package orange.java.pl2.adventurecentral.tickets.exceptions;

public class TicketsException extends Exception {

    static final long serialVersionUID = 7231375821123530132L;


    public TicketsException() {
        super();
    }

    public TicketsException(String message) {
        super(message);
    }


    public TicketsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketsException(Throwable cause) {
        super(cause);
    }

}

