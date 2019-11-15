package com.virtusa.xml.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private long id;

	private String name;

	private Node root;

	private List<Node> childNodes;

	private List<Leaf> leaves;

	public Tree() {
		childNodes = new ArrayList<Node>();
		leaves = new ArrayList<Leaf>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}

	public List<Leaf> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leaf> leaves) {
		this.leaves = leaves;
	}

	public String toString() {
		StringBuffer treeStr = new StringBuffer("");
		// treeStr.append(this.getName());
		// treeStr.append(": ");
		treeStr.append("{ ");

		if (root != null) {
			treeStr.append(root.getValue());
			treeStr.append(": ");
			List<Leaf> rootLeaves = root.getLeaves();
			printLeaves(rootLeaves, treeStr);
			treeStr.append(" ");
		}

		List<Node> childNodes = getChildNodes();
		for (Node child : childNodes) {
			treeStr.append(child.getValue());
			treeStr.append(":");
			treeStr.append(" { ");
			List<Leaf> childleaves = child.getLeaves();
			printLeaves(childleaves, treeStr);
			treeStr.append(" } ");
		}

		List<Leaf> leaves = getLeaves();
		printLeaves(leaves, treeStr);

		treeStr.append(" } ");

		return treeStr.toString();
	}

	private StringBuffer printLeaves(List<Leaf> leaves, StringBuffer leavesStr) {
		for (Leaf l : leaves) {
			leavesStr.append(" ");
			leavesStr.append(l.getName());
			leavesStr.append(":");
			leavesStr.append(l.getValue());
			leavesStr.append(",");
		}
		return leavesStr;
	}

}