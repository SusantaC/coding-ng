import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPITest {
	
	@Test (enabled = true)
	public void GetBooksDetails() { 
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1"; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.queryParam("ISBN","9781449325862").get("/book");
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		//Response response = httpRequest.request(Method.GET, "");
		//Response response = httpRequest.get("/9781449325862");
		// Print the status and message body of the response received from the server 
		System.out.println("Status received => "+ response.getStatusLine());
		//System.out.println("Response recieved => " + response.asString());
		int statusCode = response.getStatusCode();
		//System.out.println(response.getContentType());
		//System.out.println(response.getHeaders());
		//String sConnection = response.getHeader("Connection");
		//Assert.assertEquals("keep-alive", sConnection);
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		Assert.assertEquals(200, statusCode);
		JsonPath path=response.jsonPath();
		System.out.println(path.get("books[0].isbn"));
	    	
	}
	
	@Test (enabled = false)
	public void GetWeatherDetailsCondensed()
	{
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
		// Get the RequestSpecification of the request that is to be sent
		// to the server.
		RequestSpecification httpRequest = RestAssured.given();
		// Call RequestSpecification.get() method to get the response.
		// Make sure you specify the resource name.
		//Response response = httpRequest.get("");
		Response response1 = httpRequest.get("/Hyderabad");
		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("Response Body is =>  " + response1.asString());
		//System.out.println("Response Body is =>  " + response1.asString());
	}

}
