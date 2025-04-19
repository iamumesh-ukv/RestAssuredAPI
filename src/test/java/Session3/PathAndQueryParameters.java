package Session3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {


	@Test
	void testPathAndQueryParameter()
	{
		given()
		.pathParam("mypath", "users") // path parameter
		.queryParam("page", 2)  //query parameter
		.queryParam("id", 5)    //query parameter
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}

	}

