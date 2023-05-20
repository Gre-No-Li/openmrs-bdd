package com.academy.techcenture.step_defs;

import io.cucumber.java.en.*;

public class LoginStepDefs {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
    }

    @When("user enters a valid username {string}")
    public void user_enters_a_valid_username(String string) {
    }

    @When("user enters a valid password {string}")
    public void user_enters_a_valid_password(String string) {
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
    }

    @When("user enters an invalid password {string}")
    public void user_enters_an_invalid_password(String string) {
    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String string) {
    }
}
