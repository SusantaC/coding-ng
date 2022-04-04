import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {
	
	@Test
	public void UserRegistrationSuccessful() {
		RestAssured.baseURI = "https://demoqa.com";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("UserName", "test_rest"); 
		requestParams.put("Password", "rest@123345444"); 
		request.body(requestParams.toJSONString());
		Response response = request.post("/Account/v1/User");
		ResponseBody responseBody = response.getBody();
		
		JSONSuccessResponse mappedResponse = responseBody.as(JSONSuccessResponse.class);
		System.out.println(mappedResponse.getSuccessCode());
		System.out.println(mappedResponse.getMessage());
		
		
	}

}
