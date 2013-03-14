package me.tannersmith.diffbot.entity;

import me.tannersmith.diffbot.DiffbotAPIException;
import me.tannersmith.diffbot.Entity;
import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;

/**
 * Class representing a media item that would be within a page.
 * 
 * @author Tanner
 */
public class Media {
	/**
	 * Type of the media
	 * 
	 * @see Type
	 */
	private Type type;
	/**
	 * Whether or not the media is the primary media on the source
	 */
	private boolean primary;
	/**
	 * Link to the media
	 */
	private String link;
	
	/**
	 * Construct a new Media.
	 * 
	 * @param response Response from the Article API response
	 * 
	 * @throws DiffbotAPIException If unable to parse the response
	 */
	public Media(String response) throws DiffbotAPIException {
		parseResponse(response);
	}
	
	/**
	 * Parses the JSON response from the {@link Article} API response.
	 * 
	 * @see Article#parseResponse(String)
	 * @see Entity#parseResponse(String)
	 * 
	 * @throws DiffbotAPIException If unable to parse the response as JSON
	 */
	public void parseResponse(String response) throws DiffbotAPIException {
		JdomParser parser = new JdomParser();
		JsonRootNode root = null;
		
		try {
			root = parser.parse(response);
		} catch (InvalidSyntaxException e) {
			throw new DiffbotAPIException("API did not respond in a format that could be understood");
		}
		
		type = Type.getTypeFromName(root.getStringValue("type"));
				
		if (root.isNode("primary")) {
			primary = root.getBooleanValue("primary");
		}
		
		link = root.getStringValue("link");
	}
	
	/**
	 * @return Type of media
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * @return Whether or not the media is the primary media on the source
	 */
	public boolean isPrimary() {
		return primary;
	}
	
	/**
	 * @return Link to the media
	 */
	public String getLink() {
		return link;
	}
}
