package com.virtusa.xml.parser.common;

import java.util.Scanner;

import com.virtusa.xml.parser.model.Leaf;
import com.virtusa.xml.parser.model.Node;
import com.virtusa.xml.parser.model.Tree;
import com.virtusa.xml.parser.util.LeafUtility;
import com.virtusa.xml.parser.util.NodeUtility;
import com.virtusa.xml.parser.util.Utility;

public class DOMBuilder {
	
	protected Tree parseXML(Scanner file) throws Exception {
		
		Tree tree = new Tree();
        boolean isRoot = false;
        Node rootNode = null;
        Node currentNode = null;
        Node parentNode = null;
        Node node = null;
        String currentNodeName = "";

        // 4. For each line in the file, read in the line  number
        int lineNum = 0;

        // 5. Read file line by line
        outer: while ( file.hasNext() )
        {
        	// 6. Read next line
            String line = file.nextLine();   
            System.out.println();
			System.out.println("Parsing line " +  ++lineNum + ": " + line );
		
			line = Utility.validateLine(line);
			
			boolean isLineNode = NodeUtility.isNode(line);
			
			if(isLineNode) {
				
				if(!isRoot) {
					// Start of root node - Initialize 
					isRoot = true;
					rootNode = NodeUtility.getNode(line);
					currentNodeName = rootNode.getName();
					currentNode = rootNode;
					parentNode = rootNode;
				}else {
					// Child node
					node = NodeUtility.getNode(line);
					
					// If End Node Then validate node and add to tree
					if(node.isEnd()) {
						
						if(!(currentNodeName.equals(node.getName())))
							throw new Exception("Not well formed XML");
						
						if(currentNodeName.equals(rootNode.getName())) {
							tree.setRoot(rootNode);
							currentNode = null;
							System.out.println("*End of root node*");
							break outer;
						}
						
						tree.getChildNodes().add(new Node(currentNode));
						currentNode = parentNode;
						currentNodeName = parentNode.getName();
						
					}else {
						// This is a new node
						node.setParent(currentNode);
						currentNode = node;
						currentNodeName = node.getName();
					}
				}
			}else {
				// Line is a leaf
				Leaf leaf = LeafUtility.getLeaf(line);
				if(currentNode != null) {
					currentNode.getLeaves().add(leaf);
				}else {
					tree.getLeaves().add(leaf);
				}
			}
		
        }
        
        return tree;
		
	}

}