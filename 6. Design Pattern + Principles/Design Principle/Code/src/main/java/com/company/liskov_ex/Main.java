package com.company.liskov_ex;

public class Main {

	public static void main(String[] args) {
		Message msg = new Message("Bye Bye");
		testEncoding(msg);
		System.out.println("Tested message "+msg);
		
		Message another = new PlainTextMessage("Hello Hello");
		testEncoding(another);
		System.out.println("Tested message "+another);
	}
	
	private static void testEncoding(Message msg) {
		//Open connection to remote
		String encodedMsg = msg.getEncodedMessage();
		if(encodedMsg.equalsIgnoreCase(msg.getContent())) {
			System.err.println("Encoding test failed for:"+msg);
		}
		//send the message
	}
}
