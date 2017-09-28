package com.example.parser.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class StringNode {
	private String name;
	private String value;
	private boolean translatable;
	private boolean formatted;
	
	public StringNode() {
		super();
		translatable = true;
		formatted = true;
	}
	public StringNode(String name, String value, boolean translatable, boolean formatted) {
		super();
		this.name = name;
		this.value = value;
		this.translatable = translatable;
		this.formatted = formatted;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlValue
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@XmlAttribute
	public boolean isTranslatable() {
		return translatable;
	}
	public void setTranslatable(boolean translatable) {
		this.translatable = translatable;
	}
	@XmlAttribute
	public boolean isFormatted() {
		return formatted;
	}
	public void setFormatted(boolean formatted) {
		this.formatted = formatted;
	}
	
	@Override
	public String toString() {
		return "StringNode [name=" + name + ", value=" + value + ", translatable=" + translatable + ", formatted="
				+ formatted + "]";
	}
}
