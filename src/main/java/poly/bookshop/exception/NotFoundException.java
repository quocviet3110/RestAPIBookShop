package poly.bookshop.exception;

public class NotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2023729279648370033L;

	public NotFoundException(String message) {
        super(message);
    }
}