package com.virtusa.xml.parser.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.virtusa.xml.parser.model.Leaf;

public class LeafUtilityTest {

	@Test
	public void leafTest() {
		String leafTag = "<first_name>John Doe</first_name>";
		try {
			String xmlInputLine = Utility.validateLine(leafTag);
			Leaf leaf = LeafUtility.getLeaf(xmlInputLine);
			assertEquals("first_name", leaf.getName());
			assertEquals("John Doe", leaf.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}