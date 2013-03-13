package me.tannersmith.diffbot;

/**
 * This is an exception that represents a problem with retrieving an article.
 * 
 * @author Tanner Smith
 */
public class ArticleRetrievalException extends Exception {
	/**
	 * @see Exception#Exception()
	 */
	public ArticleRetrievalException() {
		super();
	}
	
	/**
	 * @see Exception#Exception(String)
	 */
	public ArticleRetrievalException(String message) {
		super(message);
	}
	
	/**
	 * @see Exception#Exception(String, Throwable)
	 */
	public ArticleRetrievalException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @see Exception#Exception(Throwable)
	 */
	public ArticleRetrievalException(Throwable cause) {
		super(cause);
	}
}
