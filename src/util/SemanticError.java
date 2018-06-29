package util;

public class SemanticError {
	/* error message string */
	private final String msg;

	/**
	 * Constructor of SemanticError.
	 *
	 * It take 1 parameter:
	 * @param msg -> error message string
	 */
	public SemanticError(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}
}
