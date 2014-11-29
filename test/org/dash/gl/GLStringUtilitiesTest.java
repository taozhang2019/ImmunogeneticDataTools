package org.dash.gl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.dash.valid.gl.GLStringConstants;
import org.dash.valid.gl.GLStringUtilities;
import org.junit.Before;
import org.junit.Test;

public class GLStringUtilitiesTest {
	private static final String HLA_A0101 = "HLA-A*0101";
	private static final String HLA_A0102 = "HLA-A*0102";
	private static final String A0101 = "0101";
	private String INVALID_GL_STRING;
	private String VALID_GL_STRING;

	@Before
	public void setUp() {
		List<String> invalidGLStrings = GLStringUtilities.readGLStringFile("resources/test/invalidShorthandExample.txt");
		INVALID_GL_STRING = invalidGLStrings.get(0);
		
		List<String> validGLStrings = GLStringUtilities.readGLStringFile("resources/test/fullyQualifiedExample.txt");
		VALID_GL_STRING = validGLStrings.get(0);
	}
	
	@Test
	public void testParse() {
		String alleleList = HLA_A0101 + GLStringConstants.ALLELE_AMBIGUITY_DELIMITER + HLA_A0102;
		List<String> elements = GLStringUtilities.parse(alleleList, GLStringConstants.ALLELE_AMBIGUITY_DELIMITER);
		assertTrue(HLA_A0101.equals(elements.get(0)));
		assertTrue(HLA_A0102.equals(elements.get(1)));
	}

	@Test
	public void testFillLocus() {
		assertTrue(HLA_A0101.equals(GLStringUtilities.fillLocus(GLStringConstants.HLA_A, A0101)));
	}
	
	@Test
	public void testValidateGLStringFormatNegative() {
		assertFalse(GLStringUtilities.validateGLStringFormat(INVALID_GL_STRING));
	}
	
	@Test
	public void testValidateGLStringFormatPostive() {
		assertTrue(GLStringUtilities.validateGLStringFormat(GLStringUtilities.fullyQualifyGLString(INVALID_GL_STRING)));
	}
	
	@Test
	public void testFullyQualifyGLString() {		
		String fullyQualifiedGLString = GLStringUtilities.fullyQualifyGLString(INVALID_GL_STRING);
		
		System.out.println(fullyQualifiedGLString);
		System.out.println(VALID_GL_STRING);
		assertTrue(VALID_GL_STRING.equals(fullyQualifiedGLString));
	}
}