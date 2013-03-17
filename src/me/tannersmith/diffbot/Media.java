package me.tannersmith.diffbot;

import argo.jdom.JsonNode;

/**
 * Class representing a media item that would be within a page.
 * 
 * @author Tanner Smith
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
	 * @param node Node element from parsed JSON
	 * 
	 * @throws DiffbotAPIException If unable to parse the response
	 */
	public Media(JsonNode node) throws DiffbotAPIException {
		parseResponse(node);
	}
	
	/**
	 * Parses the JSON response from the {@link Article} API response.
	 * 
	 * @param node Node element from parsed JSON
	 * 
	 * @throws DiffbotAPIException If unable to parse the response as JSON
	 */
	public void parseResponse(JsonNode node) throws DiffbotAPIException {		
		type = Type.getTypeFromName(node.getStringValue("type"));
				
		if (node.isNode("primary")) {
			primary = Boolean.valueOf(node.getStringValue("primary"));
		}
		
		link = node.getStringValue("link");
	}
	
	/**
	 * Return the type of media.
	 * 
	 * @return Type of media
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Return whether or not the media is the primary media on the source.
	 * 
	 * @return Whether or not the media is the primary media on the source
	 */
	public boolean isPrimary() {
		return primary;
	}
	
	/**
	 * Return a link to the media.
	 * 
	 * @return Link to the media
	 */
	public String getLink() {
		return link;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		string.append(type + " ");
		
		if (primary) {
			string.append("primary ");
		} else {
			string.append("not primary ");
		}
		
		string.append(link);
		
		return string.toString();
	}
}
