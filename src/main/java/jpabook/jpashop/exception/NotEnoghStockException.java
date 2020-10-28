package jpabook.jpashop.exception;

public class NotEnoghStockException extends RuntimeException {
    public NotEnoghStockException() {
        super();
    }

    public NotEnoghStockException(String message) {
        super(message);
    }

    public NotEnoghStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoghStockException(Throwable cause) {
        super(cause);
    }
}
