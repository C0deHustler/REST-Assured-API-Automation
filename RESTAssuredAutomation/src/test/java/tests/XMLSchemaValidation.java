package tests;

// Static imports for RestAssured methods and matchers
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class XMLSchemaValidation {

	// Test method to validate XML response schema and values
	@Test
	public void schemaValidation() throws IOException {
		// Create a File object pointing to the SOAP request XML
		File file = new File("./SoapRequest/Add.xml");

		// Check if the file exists and print appropriate message
		if (file.exists()) {
			System.out.println("    >> File Exists");
		} else {
			System.out.println("    >> File Not Found");
			return; // Exit the test if file is not found
		}

		// Read the contents of the XML file into a string
		FileInputStream fis = new FileInputStream(file);
		String requestBody = IOUtils.toString(fis, "UTF-8");

		// Set the base URI for the SOAP service
		baseURI = "http://www.dneonline.com/";

		// Send the SOAP request and validate the response
		given()
	    	.contentType("text/xml")          // Set content type to XML
	    	.accept(ContentType.XML)         // Accept XML response
	    	.body(requestBody)               // Attach the SOAP request body
	    .when()
	    	.post("/calculator.asmx")        // Send POST request to the service
	    .then()
	    	.statusCode(200)                 // Assert the status code is 200 (OK)
	    	.log().all()                     // Log the full response
	    .and()
	    	.body("//*:AddResult.text()", equalTo("14")) // Validate the response contains expected result
	    .and()
	    	.assertThat().body(matchesXsdInClasspath("Calculator.xsd")); // Validate response against the XML schema
		
		// Assert that the response body matches the XML schema defined in the "Calculator.xsd" file,
		// which should be placed in the project's classpath (typically under `src/test/resources`).
		// This validation ensures that the structure and data types in the response XML strictly adhere
		// to the expected schema – including elements, data types, and ordering if specified.
		//
		// If the schema validation fails (due to unexpected structure, missing elements, or incorrect types),
		// the test will fail, helping to catch server-side issues or contract violations early.
		//
		// Note: "Calculator.xsd" must describe the expected structure of the SOAP response (especially for AddResult).

	}
}
