package me.tannersmith.diffbot;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Main class for interaction with the Diffbot API.
 * 
 * @author Tanner Smith
 */
public class Diffbot {
	/**
	 * A Diffbot API token.
	 */
	private String token;
	/**
	 * Diffbot API URL.
	 */
	private static final String apiURL = "http://www.diffbot.com/api/";
	
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
	
	/**
	 * Construct the Article API URL to extract clean article text from news article web pages.
	 * 
	 * @param url URL to extract article from
	 * @param html Return html instead of plain text
	 * @param dontStripAds Don't strip any inline ads
	 * @param tags Generate tags for the extracted story
	 * @param comments Find the comments and identify count, link, etc
	 * @param summary Returns a summary text
	 * 
	 * @return A String of the constructed URL
	 */
	private String constructArticleAPIURL(String url, boolean html, boolean dontStripAds, boolean tags, boolean comments, boolean summary) {
		StringBuilder apiURL = new StringBuilder();
		
		try {
			url = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
			return null;
		}
		
		apiURL.append(Diffbot.apiURL);
		apiURL.append("article");
		apiURL.append("?token=" + token);
		apiURL.append("&url=" + url);
		
		if (html) {
			apiURL.append("&html");
		}
		
		if (dontStripAds) {
			apiURL.append("&dontStripAds");
		}
		
		if (tags) {
			apiURL.append("&tags");
		}
		
		if (comments) {
			apiURL.append("&comments");
		}
		
		if (summary) {
			apiURL.append("&summary");
		}
		
		return apiURL.toString();
	}
}
