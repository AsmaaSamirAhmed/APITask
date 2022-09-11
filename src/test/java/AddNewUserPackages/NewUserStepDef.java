package AddNewUserPackages;


import Pojo_Classes.Profile;
import Resources.APIResources;
import Resources.BuildData;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class NewUserStepDef extends Utils {
    RequestSpecification RequestSpec;
    ResponseSpecification ResponseSpec;
    Response response;
    int id;
    BuildData data=new BuildData();
    @Given("Add User Payload")
    public void add_user_payload() throws IOException {
       RequestSpec = given().spec(RequestSpecification())
               .body(data.AddUserPayload());
    }
    @When("call {string} with {string} http Request")
    public void call_with_http_request(String Resource, String HTTPMethod) throws IOException {
        APIResources resourceAPI= APIResources.valueOf(Resource);

        ResponseSpec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();

        if(HTTPMethod.equalsIgnoreCase("POST"))
            response =RequestSpec.when().post(resourceAPI.getResource());
        else if(HTTPMethod.equalsIgnoreCase("GET"))
            response =RequestSpec.when().get(resourceAPI.getResource());
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int StatusCode) {
        Assert.assertEquals(response.getStatusCode(),201);
    }
    @Then("return User id")
    public void return_User_id() {
        id= Integer.parseInt(getJsonPath(response,"id"));
        System.out.println("ID-->"+id);
    }

    @And("verify {string} created maps to {string} using {string} with id")
    public void verify_created_maps_to_using_with_id(String firstnameFromResponse, String nameInRequest, String resource) throws IOException {
        nameInRequest=data.getUserFirstname();
        RequestSpec=given().spec(RequestSpecification()).queryParam("id",id);
        call_with_http_request(resource,"GET");
        firstnameFromResponse=getJsonPath(response,"userDetails.profile.firstName").toString();
        firstnameFromResponse=firstnameFromResponse.replaceAll(("[^a-zA-Z0-9]"),"");
        Assert.assertEquals(firstnameFromResponse,nameInRequest);
    }
}
