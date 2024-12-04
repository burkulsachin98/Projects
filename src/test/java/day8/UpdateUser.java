package day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void test_UpdateUser(ITestContext context) {
		
		Faker faker = new Faker();

		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().emailAddress());
		data.put("gender", "female");
		data.put("status", "active");
		

		String bearerToken = "836ff473c4941408fad285c06f6583c6b21f088b5c400b5f51a84a35c1a8f674";
		int id = (Integer) context.getAttribute("user_id") ;
		
	given()
				.headers("Authorization", "Bearer " + bearerToken)
				.header("Content-Type", "application/json")
				.body(data.toString())
				.pathParam("id",id	)
				
				.when().post("https://gorest.co.in/public/v2/users/{id}")

				.then().statusCode(201)
				.extract()
				.response()
				.asString();

		
	}

}
