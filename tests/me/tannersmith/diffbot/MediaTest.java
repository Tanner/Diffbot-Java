package me.tannersmith.diffbot;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;

/**
 * Tests parsing within Media.
 * 
 * @author Tanner Smith
 */
public class MediaTest {
	@Test
	public void testCorrectParsing() {
		Media media = readMediaFromFile("tests/me/tannersmith/diffbot/media_json_good.txt");
		
		assertEquals(media.getType(), Type.IMAGE);
		assertTrue(media.isPrimary());
		assertEquals(media.getLink(), "http://s3.amazonaws.com/foofoo_large.png");
	}
	
	private static Media readMediaFromFile(String path) {
		String json = "";
		
		try {
			json = readFile(path);
		} catch (IOException e) {
			e.printStackTrace();
			
			fail(e.getMessage());
		}
		
		JdomParser parser = new JdomParser();
		JsonRootNode root = null;
		
		try {
			root = parser.parse(json);
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
			
			fail("Could not parse JSON");
		}
		
		Media media = null;
		
		try {
			media = new Media(root);
		} catch (DiffbotAPIException e) {
			e.printStackTrace();
			
			fail(e.getMessage());
		}
		
		return media;
	}
	
	private static String readFile(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}
}
