package org.rsa.payloads;

public final class GoogleMapPayLoads {

	private GoogleMapPayLoads()
	{

	}

	public static String addMapPayload()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Gyan Gori House\",\r\n"
				+ "  \"phone_number\": \"(+91) 9811678967\",\r\n"
				+ "  \"address\": \"557 B karawal Nagar\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	public static String updateAddressPayload(String placeId, String newAddress)
	{
		return "{\r\n"
		+ "\"place_id\":\""+placeId+"\",\r\n"
		+ "\"address\":\""+newAddress+"\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}";
	}

}
