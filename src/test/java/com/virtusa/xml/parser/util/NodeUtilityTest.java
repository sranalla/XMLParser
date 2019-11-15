package com.virtusa.xml.parser.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.virtusa.xml.parser.model.Node;

public class NodeUtilityTest {

	@Test
	public void isNodeTest() {
		String nodeTag = "<person>";
		try {
			String xmlInputLine = Utility.validateLine(nodeTag);
			assertEquals(true, NodeUtility.isNode(xmlInputLine));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getNodeTest() {
		String xmlInputLine = "person";
		Node node = NodeUtility.getNode(xmlInputLine);
		assertEquals("person", node.getName());
	}
}