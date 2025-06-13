package org.rsa.LibraryAPI;
import static io.restassured.RestAssured.given;
import org.rsa.payloads.DummyResponse;
import org.rsa.payloads.LibraryAPIPayload;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
public final class LibraryAPITests {

	private LibraryAPITests()
	{
		
	}

	public static JsonPath JsonConvertor(String response)
	{
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	@Test (enabled = false)
	public static void addBookWithOneData()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String respone = given().header("Content-Type","application/JSON")
		.body(LibraryAPIPayload.addOneBook())
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = JsonConvertor(respone);
		String id = js.getString("ID");
		System.out.println(id);
	}
	@Test( dataProvider = "getBookDetails", dataProviderClass = org.rsa.utility.DataProviderClass.class )
	public static void addMultipleBooks(String bookName,String isbn, String aisle, String author)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String respone = given().header("Content-Type","application/JSON")
		.body(LibraryAPIPayload.addBook(bookName,isbn,aisle,author))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = JsonConvertor(respone);
		String id = js.getString("ID");
		System.out.println(id);
	}
	
	@DataProvider (name = "BookDetails")
	public String[][] addBooks()
	{
		// Need to give data in multi dimension array format.
		String [][] bookArr  =  {{"book1","isbn1","aisle1","sumit"}
								,{"book2","isbn2","aisle2","amit"}
								,{"book3","isbn3","aisle3","pravesh"}};
		return bookArr;
	}
	
	
	
	
	
}
