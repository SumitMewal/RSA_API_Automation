package org.rsa.utility;

import org.testng.annotations.DataProvider;

public final class DataProviderClass {

	@DataProvider (name = "getBookDetails")
	public String[][] addBooks()
	{
		// Need to give data in multi dimension array format.
		String [][] bookArr  =  {{"book11","isbn11","aisle11","sumit"}
								,{"book22","isbn22","aisle22","amit"}
								,{"book33","isbn33","aisle33","pravesh"}};
		return bookArr;
	}
}
