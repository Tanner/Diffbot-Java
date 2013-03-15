package me.tannersmith.diffbot;

/**
 * Enumeration used for the Type field for {@link #Media Media}.
 * 
 * @author Tanner Smith
 */
public enum Type {
	/**
	 * Image type
	 */
	IMAGE("image"),
	/**
	 * Video type
	 */
	VIDEO("video"),
	/**
	 * Unknown type
	 */
	UNKNOWN("unknown");
	
	/**
	 * Human-readable name of the Type
	 */
	private final String name;
	
	/**
	 * Create a Type with the given name.
	 * 
	 * @param name Human-readable name of the Type
	 */
	private Type(String name) {
		this.name = name;
	}
	
	/**
	 * @return Human-readable name of the Type
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the Type type from the human-readable name.
	 * 
	 * @param name Human-readable name of a type
	 * 
	 * @return Type corresponding to the given name
	 */
	public static Type getTypeFromName(String name) {
		name = name.toLowerCase();
		
		if (name.equals(IMAGE.name)) {
			return IMAGE;
		} else if (name.equals(VIDEO.name)) {
			return VIDEO;
		} else {
			return UNKNOWN;
		}
	}
}
