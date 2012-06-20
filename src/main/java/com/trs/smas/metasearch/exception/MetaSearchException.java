package com.trs.smas.metasearch.exception;

public class MetaSearchException extends Exception {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 7772986317354960458L;

	public MetaSearchException(String message){
		super(message);
	}
	
	public MetaSearchException(Throwable cause){
		super(cause);
	}
	
	public MetaSearchException(String message,Throwable cause){
		super(message,cause);
	}
	
	/**
	 * Retrieve the innermost cause of this exception, if any.
	 * 
	 * @return the innermost exception, or <code>null</code> if none
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	/**
	 * Retrieve the most specific cause of this exception, that is, either the
	 * innermost cause (root cause) or this exception itself.
	 * <p>
	 * Differs from {@link #getRootCause()} in that it falls back to the present
	 * exception if there is no root cause.
	 * 
	 * @return the most specific cause (never <code>null</code>)
	 * @since 2.0.3
	 */
	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}
}
