package session4;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {


	@Test(priority=1)
	void testJSONResponse()
	{
		//Approach -first

		given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/book")

		.then()
		.statusCode(200)
		.header("content-Type", "application/json")
		.body("x[1].title",equalTo("Life Is What You Make It"));

	}

}
