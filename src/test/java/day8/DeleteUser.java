package day8;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class DeleteUser {

	@Test
	void testDeleteUser(ITestContext context) {



		String bearerToken ="836ff473c4941408fad285c06f6583c6b21f088b5c400b5f51a84a35c1a8f674";

		int id = (int) context.getAttribute("user_id") ;


		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)

		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();



	}
}
