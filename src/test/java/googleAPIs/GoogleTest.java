package googleAPIs;
import static io.restassured.RestAssured.given;

import org.rsa.payloads.GoogleMapPayLoads;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public final class GoogleTest {

	private GoogleTest()
	{

	}
	
	static String newAddress = "H.no 74 kunda dankot";

	@Test (priority = 1)
	public static void test1()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response	=	given()
				.queryParam("key", "qaclick123")
				.headers("Content-Type","application/json")
				.body(GoogleMapPayLoads.addMapPayload())
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		System.out.println(response);
		String placeId =  js.getString("place_id");
		System.out.println("Place Id is: "+placeId);
		
		// update the address
		given().queryParam("key", "qaclick123")
		.headers("Content-Type","application/json")
		.body(GoogleMapPayLoads.updateAddressPayload(placeId,newAddress))
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200);

		//get the updated address 
		String responseGet = 	given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.headers("Content-Type","application/json")
				.when().get("/maps/api/place/get/json")
				.then().extract().response().asString();
		JsonPath jasonPath = new JsonPath(responseGet);
		String actualAdress = jasonPath.getString("address");
		Assert.assertEquals(newAddress, actualAdress);

	}
}
