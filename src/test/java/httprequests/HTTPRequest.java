package httprequests;



import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequest {
	
	/*
	given()
	 content type, set cookies,add auth, add param, set headers info....
	when()
	get, post ,put, patch 
	then()
	validate status code, extract response extract headers cookies

	 */
	
	//@Test
	void getUser()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}
	@Test
	void createUser()
	{
		HashMap data= new HashMap();
		data.put("name","umesh");
		data.put("job", "Engineer");
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in//api/users")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
	

}
