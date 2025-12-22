package turnus.common;

public class TurnusException extends Exception {
    private static final long serialVersionUID = 1L;
    public TurnusException() { super(); }
    public TurnusException(String message) { super(message); }
    public TurnusException(Throwable cause) { super(cause); }
    public TurnusException(String message, Throwable cause) { super(message, cause); }
}
