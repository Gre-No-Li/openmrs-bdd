package com.academy.techcenture.step_defs;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.FindPatientPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.PatientPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FindPatientStepDefs {
    private WebDriver driver = Driver.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private PatientPage patientPage;
    private FindPatientPage findPatientPage;
    @Given("patient on the login page")
    public void patientOnTheLoginPage() {
        driver.get(ConfigReader.getProperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.verifyTitle();
    }

    @When("patient enters a valid username {string}")
    public void patientEntersAValidUsername(String userName) {
        loginPage.enterUserName(userName);
    }

    @And("patient enters a valid password {string}")
    public void patientEntersAValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("patient clicks on the login button")
    public void patientClicksOnTheLoginButton() {
        loginPage.clickOnInpatientWardLink();
        loginPage.clickonloginBtn();
    }

    @Then("patient should be logged in successfully and user should be navigated to Home page")
    public void patientShouldBeLoggedInSuccessfullyAndUserShouldBeNavigatedToHomePage() {
        homePage = new HomePage(driver);
        homePage.verifyTitle();
        homePage.verifyAdminTitle();
        homePage.verifyFunctionalities();
    }
    @When("user clicks on Find Patient Record button")
    public void userClicksOnFindPatientRecordButton() {
        homePage = new HomePage(driver);
        homePage.clickOnFindPatientBtn();
    }

    @Then("user should be navigated to find patient page")
    public void user_should_be_navigated_to_find_patient_page() {
        findPatientPage = new FindPatientPage(driver);
        findPatientPage.verifyTitle();
    }

    @Then("user enters patient's ID in the search by ID input")
    public void user_enters_patient_s_id_in_the_search_by_id_input() throws IOException {
        patientPage = new PatientPage(driver);
        String patientIdFromFile = Files.readString(Path.of("src/main/resources/patientid.txt"));
        System.out.println(patientIdFromFile);
        findPatientPage.enterIdInSearchInput(patientIdFromFile);
            }
    @And("user must verify the given name, it must match {string}")
    public void userMustVerifyTheGivenNameItMustMatch(String givenName) {
        patientPage.verifyPatientGivenName(givenName);
    }

    @And("user must verify the family name, it must match {string}")
    public void userMustVerifyTheFamilyNameItMustMatch(String familyName) {
        patientPage.verifyPatientFamilyName(familyName);
    }

    @And("user must verify the gender, it must match {string}")
    public void userMustVerifyTheGenderItMustMatch(String male) {
        patientPage.verifyPatientGender(male);
    }

    @And("user must verify the dob, it must match {string}.{string}.{string}")
    public void userMustVerifyTheDobItMustMatch(String day, String month, String year) {
        patientPage.verifyDob(day,month,year);
    }

    @When("user clicks on OpenMRS button")
    public void user_clicks_on_open_mrs_button() {
        patientPage.clickOnHomePageBtn();
    }

    @Then("user should be navigated to the Home Page")
    public void user_should_be_navigated_to_the_home_page() {
        homePage.verifyTitle();
    }



}
