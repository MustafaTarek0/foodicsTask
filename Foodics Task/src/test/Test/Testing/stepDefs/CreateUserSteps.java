package Testing.stepDefs;

import APis.ApiHelper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class CreateUserSteps {

    private String jsonFileName;
    private String method;
    private String endpoint;
    private Response response;


    @Given("the API base URL is set")
    public void the_api_base_url_is_set() {

    }

    @And("I have the JSON payload from file {string}")
    public void i_have_the_json_payload_from_file(String fileName) {
        this.jsonFileName = fileName;
    }

    @When("I send a {string} request to {string}")
    public void i_send_a_request_to(String method, String endpoint) {

        this.method = method;
        this.endpoint = endpoint;
        response = ApiHelper.execute(method, endpoint, jsonFileName);
    }

    @Then("the response status code should be {string}")
    public void the_response_status_code_should_be(String statusCode) {
        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode), "Status code mismatch!");
    }

    @And("the response should contain a user ID ,email ,firstName ,lastName , avatar , updated At")
    public void the_response_should_contain_a_user_id() {
        String id = response.jsonPath().getString("id");
        String email = response.jsonPath().getString("email");
        String firstName = response.jsonPath().getString("first_name");
        String lastName = response.jsonPath().getString("last_name");
        Assert.assertNotNull(id, "User ID is missing in the response");
        Assert.assertNotNull(email, "email is missing in the response");
        Assert.assertNotNull(firstName, "firstname is missing in the response");
        Assert.assertNotNull(lastName, "lastname is missing in the response");
    }



    @And("")
    public void theResponseShouldContainAUserIDEmailFirstNameLastNameAvatarUpdatedAt() {
    }

    @And("the response should contain a user ID ,email ,firstName ,lastName , avatar , avatar")
    public void theResponseShouldContainAUserIDEmailFirstNameLastNameAvatarAvatar() {
        System.out.println(response.getBody().asString());
        String id = response.jsonPath().getString("data.id");
        String email = response.jsonPath().getString("data.email");
        String firstName = response.jsonPath().getString("data.first_name");
        String lastName = response.jsonPath().getString("data.last_name");
        Assert.assertNotNull(id, "User ID is missing in the response");
       Assert.assertNotNull(email, "email is missing in the response");
        Assert.assertNotNull(firstName, "firstname is missing in the response");
        Assert.assertNotNull(lastName, "lastname is missing in the response");
    }
}
