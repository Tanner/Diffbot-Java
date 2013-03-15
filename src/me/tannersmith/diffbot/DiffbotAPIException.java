package me.tannersmith.diffbot;

/**
 * This is an exception that represents a problem with retrieving an article.
 * 
 * @author Tanner Smith
 */
public class DiffbotAPIException extends Exception {
	/**
	 * Constructs a DiffbotAPIException with no detail message.
	 * 
	 * @see Exception#Exception()
	 */
	public DiffbotAPIException() {
		super();
	}
	
	/**
	 * Constructs a DiffbotAPIException with a detail message.
	 * 
	 * @see Exception#Exception(String)
	 */
	public DiffbotAPIException(String message) {
		super(message);
	}
	
	/**
	 * Constructs a DiffbotAPIException with a detail message and a cause.
	 * 
	 * @see Exception#Exception(String, Throwable)
	 */
	public DiffbotAPIException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructs a DiffbotAPIException with a cause.
	 * 
	 * @see Exception#Exception(Throwable)
	 */
	public DiffbotAPIException(Throwable cause) {
		super(cause);
	}
}
