package me.tannersmith.diffbot;

/**
 * This class represents a Diffbot Article.
 * 
 * Created from http://www.diffbot.com/our-apis/article/
 * 
 * @author Tanner
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
	 */
	public Article() {
		// Nothing so far
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
