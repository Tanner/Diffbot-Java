package me.tannersmith.diffbot;

/**
 * A generic entity for the Diffbot API.
 * 
 * @author Tanner Smith
 */
public interface Entity {
	/**
	 * Parse the response given from the Diffbot API servers.
	 * 
	 * @param response The response (may be XML, JSON, etc...)
	 * 
	 * @throws DiffbotAPIException If unable to parse the response
	 */
	public void parseResponse(String response) throws DiffbotAPIException;
}
