package com.example.demo.tests;

import com.example.demo.DemoApplicationTests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.*;

public class RestApiTests extends DemoApplicationTests{
	
	@Test
	@DisplayName("First test")
	public void id10001() {
		RequestSpecification requestSpec = firstFeatureSteps.makeRequestSpecStep();
		Response response = firstFeatureSteps.makeGetRequest(requestSpec, "/api/users");
		firstFeatureSteps.responseCodeShouldBeWithJson(response, 200);
	}
}
