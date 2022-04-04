import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPITest1 {
	
	@Test (enabled = true)
		public void UserRegistrationSuccessful() 
		{ 
		    RestAssured.baseURI ="https://demoqa.com/Account/v1"; 
		    RequestSpecification request = RestAssured.given(); 
		    JSONObject requestParams = new JSONObject();
		    requestParams.put("userName", "test_rest");
		    requestParams.put("password", "Testrest@1235"); 
		    request.body(requestParams.toJSONString());
		    Response response = request.post("/User"); 
		    ResponseBody body = response.getBody();
		    System.out.println(response.getStatusLine());
		    System.out.println(body.asString());
		     
		}
	}
	
