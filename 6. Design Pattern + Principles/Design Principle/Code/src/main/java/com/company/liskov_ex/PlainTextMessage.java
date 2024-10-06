package com.company.liskov_ex;

public class PlainTextMessage extends Message {

	public PlainTextMessage(String content) {
		super(content);
	}
	
	public String getEncodedMessage() {
		return content;
	}

	@Override
	public String toString() {
		return "PlainTextMessage [content=" + content + "]";
	}
	
	
}
