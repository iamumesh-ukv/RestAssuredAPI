package session1;



import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
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
	int id;

	@Test(priority=1)
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
	@Test(priority=2)
	void createUser()
	{
		HashMap data= new HashMap();
		data.put("name","AAMAR");
		data.put("job", "Engn");


		id=given()
				.contentType("application/json")
				.body(data)

				.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");

		//		.then()
		//		.statusCode(201)
		//		.log().all();
	}
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{
		 
		HashMap data= new HashMap();
		data.put("name","Nareshh");
		data.put("job", "Contra");


		given()
		.contentType("application/json")
		.body(data)

		.when()
		.put("https://reqres.in/api/users/" + id)

		.then()
		.statusCode(200)
		.log().all();
	}
}
