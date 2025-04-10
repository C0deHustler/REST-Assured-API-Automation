package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostTests {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel"));
	}

	@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Name", "Raghav");
		map.put("Job", "Teacher");
		System.out.println(map);

		// Converting HashMap to JSON Post request
		JSONObject request1 = new JSONObject(map);
		System.out.println(request1.toString());

		// Creating JSON Post request without using HashMap
		JSONObject request2 = new JSONObject();
		request2.put("Sports", "Cricket");
		request2.put("Popularity", "India");
		System.out.println(request2.toJSONString());

		// Submitting a POST request to the "/users" endpoint with a JSON payload,
		// verifying a 201 Created status code, and logging the response—used to test
		// user creation functionality.
		baseURI = "https://reqres.in/api";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request1.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}
