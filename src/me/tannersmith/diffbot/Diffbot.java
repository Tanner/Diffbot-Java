package me.tannersmith.diffbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
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
	
	public Article getArticle(String url, boolean html, boolean dontStripAds, boolean tags, boolean comments, boolean summary) throws DiffbotAPIException {
		URL articleAPIURL = null;
		String content = null;
		
		try {
			articleAPIURL = new URL(constructArticleAPIURL(url, html, dontStripAds, tags, comments, summary));
		} catch (MalformedURLException e) {			
			throw new DiffbotAPIException("Unable to create API request URL");
		}
		
		try {
			content = requestURLContent(articleAPIURL);
		} catch (IOException e) {
			throw new DiffbotAPIException("Unable to make API request");
		}
		
		return new Article(content);
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
	
	/**
	 * Request the content at a URL.
	 * 
	 * @param url URL object for the requested URL
	 * 
	 * @return String containing the content at the URL
	 * @throws IOException If there is a problem accessing the page
	 */
	private String requestURLContent(URL url) throws IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		StringBuilder content = new StringBuilder();
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		
		in.close();
		
		return content.toString();
	}
}
