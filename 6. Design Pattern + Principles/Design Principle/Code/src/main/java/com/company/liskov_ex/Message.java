package com.company.liskov_ex;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Message {

	protected String content;
	
	public Message(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getEncodedMessage() {
		if(content == null) {
			return null;
		}
		try {
			return Base64.getEncoder().encodeToString(content.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return "Message [content=" + content + "]";
	}
	
}
