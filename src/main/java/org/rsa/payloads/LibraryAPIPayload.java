package org.rsa.payloads;

public final class LibraryAPIPayload {

	private LibraryAPIPayload()
	{
		
	}
	
	public static String addBook(String bookName,String isbn, String aisle, String author)
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\""+bookName+"\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\""+author+"\"\r\n"
				+ "}";
	}
	
	public static String addOneBook()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcd\",\r\n"
				+ "\"aisle\":\"227\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
	}
	
}
