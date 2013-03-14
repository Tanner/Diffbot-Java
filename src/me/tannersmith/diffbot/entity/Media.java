package me.tannersmith.diffbot.entity;

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
