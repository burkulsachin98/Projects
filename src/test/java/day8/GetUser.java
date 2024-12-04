package day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GetUser {
	
	@Test
	void test_GetUser(ITestContext context) {
		
		int id = (Integer) context.getAttribute("user_id") ;// this should comes from create user request
		
			String bearerToken= "836ff473c4941408fad285c06f6583c6b21f088b5c400b5f51a84a35c1a8f674";
			 given()
			 .headers("Authorization","Bearer "+bearerToken)	
			 .pathParam("id", id)
			 .when()
			 .get("https://gorest.co.in/public/v2/users/{id}")
			 .then()
			 .statusCode(200)
			 .log().all();
			 
			 
			 
			 
			 
			 
			 
			 
			 
	}

}
