package Session3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoggingDiffWaysToShow {
	
	
	@Test(priority= 1)
	void testLogs()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		//.log().all();  // you can print all info 
		//.log().body();   // you can print body only
		.log().headers();   //  you can print headers only
		
		
	}

}
