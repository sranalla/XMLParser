package com.virtusa.xml.parser;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void systemUnderTest() {
		String inputFile = "SampleXML";
		Application application = new Application();
		application.parseXML(inputFile);
	}
}