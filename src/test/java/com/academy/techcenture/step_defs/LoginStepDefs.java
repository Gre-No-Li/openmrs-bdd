package com.academy.techcenture.step_defs;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
    private WebDriver driver = Driver.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get(ConfigReader.getProperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.verifyTitle();
    }

    @When("user enters a valid username {string}")
    public void user_enters_a_valid_username(String userName) {
        loginPage.enterUserName(userName);
    }

    @When("user enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickOnInpatientWardLink();
        loginPage.clickonloginBtn();
    }

    @Then("user should be logged in successfully and user should be navigated to Home page")
    public void userShouldBeLoggedInSuccessfullyAndUserShouldBeNavigatedToHomePage() {
        homePage = new HomePage(driver);
        homePage.verifyTitle();
        homePage.verifyAdminTitle();
        homePage.verifyFunctionalities();
    }

    @When("user enters an invalid password {string}")
    public void user_enters_an_invalid_password(String invalidPassword) {
        loginPage.enterInvalidPassword(invalidPassword);
    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String errorMsg) {
        loginPage.verifyErrorMsg(errorMsg);
    }


}
