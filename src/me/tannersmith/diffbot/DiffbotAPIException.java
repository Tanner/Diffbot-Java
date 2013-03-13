package me.tannersmith.diffbot;

/**
 * This is an exception that represents a problem with retrieving an article.
 * 
 * @author Tanner Smith
 */
public class DiffbotAPIException extends Exception {
	/**
	 * @see Exception#Exception()
	 */
	public DiffbotAPIException() {
		super();
	}
	
	/**
	 * @see Exception#Exception(String)
	 */
	public DiffbotAPIException(String message) {
		super(message);
	}
	
	/**
	 * @see Exception#Exception(String, Throwable)
	 */
	public DiffbotAPIException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @see Exception#Exception(Throwable)
	 */
	public DiffbotAPIException(Throwable cause) {
		super(cause);
	}
}
