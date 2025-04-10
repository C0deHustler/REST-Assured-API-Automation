package tests;

// Importing necessary static methods from RestAssured
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class SoapXMLRequest {

	/**
	 * This test validates a SOAP XML request to an online calculator web service.
	 * It sends a request to add two numbers and verifies that the response status
	 * is 200 (OK).
	 */
	@Test
	public void validateSoapXML() throws IOException {
		// Creating a File object pointing to the SOAP request XML file
		File file = new File("./SoapRequest/Add.xml");

		// Checking if the file exists before proceeding
		if (file.exists()) {
			System.out.println("    >> File Exists");
		} else {
			System.out.println("    >> File Not Found");
			return;
		}

		// Creating FileInputStream to read the XML content
		FileInputStream fis = new FileInputStream(file);

		// Converting FileInputStream into a String using Apache Commons IO
		String requestBody = IOUtils.toString(fis, "UTF-8");

		// Setting the base URI of the SOAP web service
		baseURI = "http://www.dneonline.com/";

		// Sending the SOAP request using POST method
		// Setting content type to text/xml, accepting XML response
		// Sending the request body read from the XML file
		// Validating that the response has status code 200
		// Logging the full response
		given()
	    	.contentType("text/xml")
	    	.accept(ContentType.XML)
	    	.body(requestBody)
	    .when()
	    	.post("/calculator.asmx")
	    .then()
	    	.statusCode(200)
	    	.log().all();

		
		
		System.out.println("----------------------------------------------------------");
		System.out.println("Validation of the Addition result: ");
		System.out.println("----------------------------------------------------------");
		// Validation of SOAP XML Response body 
		given()
		    .contentType("text/xml")
		    .accept(ContentType.XML)
		    .body(requestBody)
		.when()
		    .post("/calculator.asmx")
		.then()
		    .statusCode(200)
		    .log().all()
		// After sending the SOAP request and getting the full response in the console as 
		// the output of the previously written code,
		// we manually analyze the XML structure of the response.
		// Based on the XML, we identify that the main result value (e.g., 14) is inside the <AddResult> tag.
		// To locate this tag in the response, we write an XPath expression: '//*:AddResult.text()'
		// The wildcard prefix *: is used to ignore any XML namespaces, making the XPath more flexible.
		// Finally, we assert that the value inside <AddResult> is exactly "14", confirming correct behavior.
		.and()
		    .body("//*:AddResult.text()", equalTo("14"));


	}
}
