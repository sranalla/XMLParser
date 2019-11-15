package com.virtusa.xml.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private boolean start;

	private boolean end;

	private boolean root;

	private List<Leaf> leaves;

	private Node parent;

	private Node child;

	private String name;

	private String value;

	public Node() {
		start = false;
		end = false;
		leaves = new ArrayList<Leaf>();
	}

	public Node(Node n) {
		List<Leaf> sourceLeaves = n.getLeaves();
		List<Leaf> destLeaves = new ArrayList<Leaf>();
		for (Leaf f : sourceLeaves) {
			Leaf leaf = new Leaf();
			leaf.setName(new String(f.getName()));
			leaf.setValue(new String(f.getValue()));
			destLeaves.add(leaf);
		}
		this.setLeaves(destLeaves);
		this.setStart(n.isStart());
		this.setEnd(n.isEnd());
		this.setName(n.getName());
		this.setValue(n.getValue());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public List<Leaf> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leaf> leaves) {
		this.leaves = leaves;
	}

	public String toString() {
		StringBuffer leavesStr = new StringBuffer("");
		leavesStr.append(" { ");
		for (Leaf l : leaves) {
			leavesStr.append(" ");
			leavesStr.append(l.getName());
			leavesStr.append(":");
			leavesStr.append(l.getValue());
		}
		leavesStr.append(" } ");
		return leavesStr.toString();
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

}