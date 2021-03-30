package com.example.demo.steps;

import org.springframework.stereotype.Service;

import com.example.demo.utils.AbstractFeatureSteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Service
public class FirstFeatureSteps extends AbstractFeatureSteps {
    
    @Step("^I preparing GET request specification$")
    public RequestSpecification makeRequestSpecStep() {
        reqSpec = requestSpecifications.getDefaultRequestSpecification();
        return reqSpec;
    }

    @Step("^I make GET request to (.*) endpoint$")
    public Response makeGetRequest(RequestSpecification requestSpecification, String endpoint) {
        response = httpClient.restGet(reqSpec, endpoint);
        return response;
    }

    @Step("^I should see (.*) response code with json body$")
    public void responseCodeShouldBeWithJson(Response response, int expectStatusCode) {
        response.then().spec(responseSpecifications.getDefaultResponseSpecification(expectStatusCode));
    }
}
