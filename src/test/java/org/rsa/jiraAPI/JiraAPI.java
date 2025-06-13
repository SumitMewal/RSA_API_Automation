package org.rsa.jiraAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;
public final class JiraAPI {

	@Test
	public void jiraAPIAutomation()
	{
		// Creation of Project
		RestAssured.baseURI = "https://sumitsmewal.atlassian.net";
		String projectResponse = 	given().header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization", "Basic c3VtaXRzbWV3YWxAZ21haWwuY29tOkFUQVRUM3hGZkdGMDV2aVJwQzh5cHFRTXVxRFhrakdKTjN0aWp4ZTJlQ1ZUQ3dHUmc4TV9YWFd3U0huTDBoZnhkekFoeWFsOGRqQnEyVV80VUZxU2hkcWpEaUVqN0FiZDEwS0ZVU1NkbGRoQ3NRNEhxV1RORElLMVZLNEJsVF9vREdvczlySGRvM3lzV0ZvbnRDekpMaGJDMHU3a3N1VHdvb2NjMkJIOHpnSEFqYjdwbzhDUnpIVT1GNDIxQUJEMg==")
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "       \"project\":\r\n"
						+ "       {\r\n"
						+ "          \"key\": \"AAT\"\r\n"
						+ "       },\r\n"
						+ "       \"summary\": \"First bug created using api automation rest Assured\",\r\n"
						+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
						+ "       \"issuetype\": {\r\n"
						+ "          \"name\": \"Bug\"\r\n"
						+ "       }\r\n"
						+ "   }\r\n"
						+ "}")
				.when().post("rest/api/2/issue")
				.then().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(projectResponse);
		String issueId = js.getString("id");
		System.out.println(issueId);

		String path = "C:\\Users\\sumit\\Downloads\\IMG_4053.jpeg";
		String image = "C:\\Users\\sumit\\OneDrive\\Desktop\\SuperProf\\Attachment\\attachment.png";
		// ******Add attachment to the above issue

		given().header("Accept","application/json")
		.pathParam("key",issueId )
		.header("Authorization", "Basic c3VtaXRzbWV3YWxAZ21haWwuY29tOkFUQVRUM3hGZkdGMDV2aVJwQzh5cHFRTXVxRFhrakdKTjN0aWp4ZTJlQ1ZUQ3dHUmc4TV9YWFd3U0huTDBoZnhkekFoeWFsOGRqQnEyVV80VUZxU2hkcWpEaUVqN0FiZDEwS0ZVU1NkbGRoQ3NRNEhxV1RORElLMVZLNEJsVF9vREdvczlySGRvM3lzV0ZvbnRDekpMaGJDMHU3a3N1VHdvb2NjMkJIOHpnSEFqYjdwbzhDUnpIVT1GNDIxQUJEMg==")
		.multiPart("file",new File(path))
		.log().all()
		.when().post("rest/api/2/issue/{key}/attachments")
		.then().assertThat().statusCode(200)
		.extract().response().asString();


	}



}
