package me.tannersmith.diffbot;

/**
 * This class represents a Diffbot Article.
 * 
 * Created from http://www.diffbot.com/our-apis/article/
 * 
 * @author Tanner
 */
public class Article {
	private String text;
	private String title;
	
	private String date;
	private String author;
	
	private String nextPage;
	private int numPages;
	
	private String url;
	private String resolvedURL;
	
	private String xpath;
	private String icon;
	
	private String html;
	private String[] tags;
	private String summary;
	
	/**
	 * Construct a new Article.
	 */
	public Article() {
		// Nothing so far
	}
}
