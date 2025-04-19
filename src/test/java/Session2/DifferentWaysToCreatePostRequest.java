package Session2;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class DifferentWaysToCreatePostRequest {
	
	/*
Post Http method > How many ways we create request body
1.	Hashmap
2.	using org.json
3.	using POJO (Plain Old java Object)
4.	using external java file 

	 */
	
	int id; 
	@Test(priority=1)
	void testPostusingHashMap()
	{
		HashMap data =new HashMap();
		
		data.put("name","Kamal");
		data.put("location","Aligarh");
		data.put("phone","8910203040");
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Kamal"))
		.body("location",equalTo("Aligarh"))
		.body("phone",equalTo("8910203040"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type","application/json")
		.log().all();
			
	}
	
	//deleting the record
	@Test(priority=2)
	void testDelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/a7f5")
		
		.then()
		.statusCode(200);
	}

}
