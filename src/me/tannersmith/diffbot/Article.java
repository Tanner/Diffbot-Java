package me.tannersmith.diffbot;

import java.util.List;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;

/**
 * This class represents a Diffbot Article.
 * 
 * Created from http://www.diffbot.com/our-apis/article/
 * 
 * @author Tanner Smith
 */
public class Article {
	/**
	 * Plain-text of the extracted article
	 */
	private String text;
	/**
	 * Title of extracted article
	 */
	private String title;
	/**
	 * Article date (if detected)
	 */
	private String date;
	/**
	 * Article author (if detected)
	 */
	private String author;
	/**
	 * Link to the next page of a multi-page article (if detected)
	 */
	private String nextPage;
	/**
	 * Number of pages automatically concatenated to form the text response
	 */
	private int numPages;
	/**
	 * Media items (images or videos), if detected and extracted
	 */
	private Media[] media;
	/**
	 * Actual URL of original source
	 */
	private String url;
	/**
	 * XPath expression identifying the node containing the article contents
	 */
	private String xpath;
	/**
	 * Page favicon
	 */
	private String icon;
	/**
	 * HTML of the extracted article
	 */
	private String html;
	/**
	 * Array of tags of the article
	 */
	private String[] tags;
	/**
	 * Summary text of the article
	 */
	private String summary;
	
	/**
	 * Construct a new Article.
	 * 
	 * @param response Response from the API server
	 * 
	 * @throws DiffbotAPIException If unable to parse the response
	 */
	public Article(String response) throws DiffbotAPIException {
		parseResponse(response);
	}
	
	/**
	 * Parses the JSON response from the API server.
	 * 
	 * @param response JSON response from the API server
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
		
		text = root.getStringValue("text");
		title = root.getStringValue("title");
		
		if (root.isNode("date")) {
			date = root.getStringValue("date");
		}
		
		if (root.isNode("author")) {
			author = root.getStringValue("author");
		}
		
		if (root.isNode("nextPage")) {
			nextPage = root.getStringValue("nextPage");
		}
		
		if (root.isNode("numPages")) {
			numPages = Integer.parseInt(root.getNumberValue("numPages"));
		}
		
		url = root.getStringValue("url");
		xpath = root.getStringValue("xpath");
		icon = root.getStringValue("icon");
		html = root.getStringValue("html");
		
		if (root.isNode("media")) {
			JsonRootNode mediaNode = root.getRootNode("media");
			List<JsonNode> elements = mediaNode.getElements();
			
			media = new Media[elements.size()];
			
			for (int i = 0; i < media.length; i++) {
				JsonNode node = elements.get(i);
				
				media[i] = new Media(node);
			}
		}
		
		if (root.isNode("tags")) {
			JsonRootNode tagNode = root.getRootNode("tags");
			List<JsonNode> elements = tagNode.getElements();
			
			tags = new String[elements.size()];
			
			for (int i = 0; i < tags.length; i++) {
				JsonNode node = elements.get(i);
				
				tags[i] = node.getText();
			}
		}
		
		if (root.isNode("summary")) {
			summary = root.getStringValue("summary");
		}
	}

	/**
	 * Return extracted text from the article.
	 * 
	 * @return Article text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Return title of article.
	 * 
	 * @return Title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns date of the article.
	 * 
	 * @return Date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Return author of the article.
	 * 
	 * @return Author's name
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Return next page URL, if any.
	 * 
	 * @return Next page URL
	 */
	public String getNextPage() {
		return nextPage;
	}

	/**
	 * Return the number of pages in the article, if any.
	 * 
	 * @return Number pages for the article
	 */
	public int getNumPages() {
		return numPages;
	}

	/**
	 * Return the URL of the article.
	 * 
	 * @return URL of the article
	 */
	public String getURL() {
		return url;
	}

	/**
	 * Return the XPath expression for the article.
	 * 
	 * @return XPath expression
	 */
	public String getXPath() {
		return xpath;
	}

	/**
	 * Return the favicon for the website the article is on.
	 * 
	 * @return Favicon URL
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Return the HTML source for the article.
	 * 
	 * @return HTML
	 */
	public String getHTML() {
		return html;
	}

	/**
	 * Return the array of tags for the article.
	 * 
	 * @return Array of String tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * Return the calculated summary of the article.
	 * 
	 * @return Summary of the article
	 */
	public String getSummary() {
		return summary;
	}
}
