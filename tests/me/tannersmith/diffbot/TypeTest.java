package me.tannersmith.diffbot;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests various features within the Type enum.
 * 
 * @author Tanner Smith
 */
public class TypeTest {
	@Test
	public void testTypeFromName() {
		assertEquals(Type.getTypeFromName("image"), Type.IMAGE);
		assertEquals(Type.getTypeFromName("IMAGE"), Type.IMAGE);
		
		assertEquals(Type.getTypeFromName("video"), Type.VIDEO);
		assertEquals(Type.getTypeFromName("VIDEO"), Type.VIDEO);

		assertEquals(Type.getTypeFromName("kitty"), Type.UNKNOWN);
	}
}
