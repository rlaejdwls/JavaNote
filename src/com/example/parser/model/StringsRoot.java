package com.example.parser.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resources")
public class StringsRoot {
	private List<StringNode> string;

	public StringsRoot() {
		super();
	}
	public StringsRoot(List<StringNode> string) {
		super();
		this.string = string;
	}
	
	public List<StringNode> getString() {
		return string;
	}
	@XmlElement
	public void setString(List<StringNode> string) {
		this.string = string;
	}
	public StringNode get(int index) {
		return string.get(index);
	}
	public int size() {
		return string.size();
	}
	
	@Override
	public String toString() {
		return "StringsModel [string=" + string + "]";
	}
}
