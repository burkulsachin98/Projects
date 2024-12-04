package day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class DemoCreateUser {
	@Test
	void demoCreateUser() {
		
		
		
		RestAssured.baseURI = "https://gorest.co.in/";
		String bearerToken= "836ff473c4941408fad285c06f6583c6b21f088b5c400b5f51a84a35c1a8f674";		 
		Response postResponse = given()
				.headers("Authorization","Bearer "+bearerToken)
	               .contentType("application/json")
	                .body("{ \"name\": \"John Doe\", \"email\": \"john.do21e@example.com\",\"gender\": \"male\",\"staus\":\"inactive\" }")
	                .when()
	                .post("/public/v2/users")
	                .then()
	                .statusCode(201)
	                .extract()
	                .response();
		 
		 
	       String userId = postResponse.jsonPath().getString("id");
	        System.out.println("Created User ID: " + userId);
	}

}
