package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

	@Test
	public void testPut() {
		// Creating JSON Post request without using HashMap
		JSONObject request = new JSONObject();
		request.put("Sports", "Cricket");
		request.put("GOAT", "Sachin Tendulkar");
		System.out.println(request.toJSONString());

		// Submitting a PUT request to the "/users/2" endpoint with a JSON payload,
		// verifying a 200 OK status code, and logging the response—used to test
		// user update functionality.
		baseURI = "https://reqres.in";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}
	
	
	@Test
	public void testPatch() {
		// Creating JSON Post request without using HashMap
		JSONObject request = new JSONObject();
		request.put("Sports", "Football");
		request.put("GOAT", "Messi");
		System.out.println(request.toJSONString());

		// Submitting a PATCH request to the "/api/users/2" endpoint with a JSON payload,
		// verifying a 200 OK status code, and logging the response—used to test
		// partial update functionality for an existing user.
		baseURI = "https://reqres.in";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();
	}
	
	
	@Test
	public void testDelete() {
		// Submitting a DELETE request to the "/api/users/2" endpoint without a request body,
		// verifying a 204 No Content status code, and logging the response—used to test
		// deletion of a user.
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").then().statusCode(204).log().all();
	}
}
