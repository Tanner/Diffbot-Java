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
	 * @return Article text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return Title of the article
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return Date of the article
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return Author of the article
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return Next page URL for the article
	 */
	public String getNextPage() {
		return nextPage;
	}

	/**
	 * @return Number pages for the article
	 */
	public int getNumPages() {
		return numPages;
	}

	/**
	 * @return URL of the article
	 */
	public String getURL() {
		return url;
	}

	/**
	 * @return XPath expression for the article
	 */
	public String getXPath() {
		return xpath;
	}

	/**
	 * @return Favicon for the article
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @return HTML of the article
	 */
	public String getHTML() {
		return html;
	}

	/**
	 * @return Array of tags about the article
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @return Summary of the article
	 */
	public String getSummary() {
		return summary;
	}
}
