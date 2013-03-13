package me.tannersmith.diffbot;

/**
 * Main class for interaction with the Diffbot API.
 * 
 * @author Tanner Smith
 */
public class Diffbot {
	private String token;
	
	/**
	 * Construct a new Diffbot using the provided API token.
	 * 
	 * @param token A Diffbot API token
	 */
	public Diffbot(String token) {
		this.token = token;
		
		if (token.length() == 0) {
			throw new IllegalArgumentException("API token must not be of length zero.");
		}
	}
}
