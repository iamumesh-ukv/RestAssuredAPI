package Session3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

	//@Test(priority=1)
	void testHeaders()
	{
		given()


		.when()
		.get("https://www.google.com/")

		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server", "gws");

	}
	@Test(priority=2)
	void gettHeaders()
	{
		Response res=given()

				.when()
				.get("https://www.google.com/");

		//get Single header info
		//String headervalue	= res.getHeader("Content-Type");
		//System.out.println("The value of content type header is :" + headervalue);
		
		
		 Headers myHeader=res.getHeaders();
		 
		 for (Header hd:myHeader)
		 {
			System.out.println(hd.getName()+" "+ hd.getValue());
		 }
	}

}
