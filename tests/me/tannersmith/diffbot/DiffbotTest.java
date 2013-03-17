package me.tannersmith.diffbot;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests various features within the Diffbot class.
 * 
 * @author Tanner Smith
 */
public class DiffbotTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createWithAPIToken() {
		Diffbot bot = new Diffbot("some-api-token");
		
		assertNotNull("should not be null", bot);
	}
	
	@Test
	public void createWithoutAPIToken() throws IllegalArgumentException {		
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("API token must not be of length zero.");
        
		Diffbot bot = new Diffbot("");
		
		System.out.println(bot);
	}
}
