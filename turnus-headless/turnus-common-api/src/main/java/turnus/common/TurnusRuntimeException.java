package turnus.common;

public class TurnusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public TurnusRuntimeException() { super(); }
    public TurnusRuntimeException(String message) { super(message); }
    public TurnusRuntimeException(Throwable cause) { super(cause); }
    public TurnusRuntimeException(String message, Throwable cause) { super(message, cause); }
}
