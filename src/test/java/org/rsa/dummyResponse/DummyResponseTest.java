package org.rsa.dummyResponse;

import java.util.List;

import org.rsa.payloads.DummyResponse;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class DummyResponseTest {

	/*
	1. Print No of courses returned by API

	2.Print Purchase Amount

	3. Print Title of the first course

	4. Print All course titles and their respective Prices

	5. Print no of copies sold by RPA Course

	6. Verify if Sum of all Course prices matches with Purchase Amount
	 */

	static JsonPath bookJson = JsonConvertor();

	public static JsonPath JsonConvertor()
	{
		JsonPath js = new JsonPath(DummyResponse.bookResponseDummy());
		return js;
	}

	@Test (priority = 1)
	public void printNoOfCoursers()
	{
		// converted first to the list then get the size of that list
		int numberOfCourses = bookJson.getList("courses").size();
		System.out.println("Number of course : "+numberOfCourses);
	}

	@Test (priority = 2)
	public void printPurchaseAmount()
	{
		String purchaseAmount = bookJson.getString("dashboard.purchaseAmount");
		System.out.println("Purchase Amount : "+purchaseAmount);
	}

	@Test (priority = 3)
	public void printTitleOfFirstCourse()
	{
		String firstCourse = bookJson.getList("courses.title").get(0).toString();
		System.out.println("Title of First Course : "+firstCourse);
	}

	@Test(priority = 4)
	public void printCopies()
	{
		System.out.println("Copies sold by RPA : "+getCopies("RPA"));
	}

	@Test(priority = 5)
	public void comparePurchasePrice()
	{
		int actualPurchasePrice = courseTotalPrice();
		int expectedPurchasePrice = bookJson.getInt("dashboard.purchaseAmount");
		if (actualPurchasePrice==expectedPurchasePrice)
		{
			System.out.println("Price mathced and Correct !!");
		}
		else
		{
			System.out.println("Price not mathced or Incorrect !!");
		}
	}

	public static String getCopies(String title)
	{
		String copies = null;
		List<String> courseList =	bookJson.getList("courses.title");
		for (int i = 0;i<courseList.size();i++)
		{
			// This is used to get the index on the basis of course title
			if (courseList.get(i).toString().equalsIgnoreCase(title))
			{
				copies = bookJson.getString("courses["+i+"].copies").toString();
			}
		}
		return copies;
	}

	public static int courseTotalPrice()
	{
		int copies ;
		int price;
		int totalPrice = 0;
		List<String> courseList =	bookJson.getList("courses.title");
		for (int i = 0;i<courseList.size();i++)
		{
			copies = bookJson.getInt("courses["+i+"].copies");
			price = bookJson.getInt("courses["+i+"].price");
			totalPrice = totalPrice + copies * price; 
		}
		return totalPrice;
	}

}
