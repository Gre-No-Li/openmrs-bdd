package com.academy.techcenture.step_defs;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.PatientPage;
import com.academy.techcenture.pages.RegisterPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegistrationStepDefs {
    private WebDriver driver = Driver.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private RegisterPage registerPage;
    private PatientPage patientPage;
    @Given("this user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get(ConfigReader.getProperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.verifyTitle();
    }

    @When("this user enters a valid username {string}")
    public void user_enters_a_valid_username(String userName) {
        loginPage.enterUserName(userName);
    }

    @When("this user enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("this user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickOnInpatientWardLink();
        loginPage.clickonloginBtn();
    }

    @Then("this user should be logged in successfully and user should be navigated to Home page")
    public void userShouldBeLoggedInSuccessfullyAndUserShouldBeNavigatedToHomePage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.verifyTitle();
        homePage.verifyAdminTitle();
        homePage.verifyFunctionalities();
    }

    @When("this user clicks on Register a patient button")
    public void user_clicks_on_register_a_patient_button() {
        homePage.clickOnRegisterPatientBtn();
    }

    @Then("user should be navigated to a register patient page")
    public void user_should_be_navigated_to_a_register_patient_page() {
        registerPage = new RegisterPage(driver);
        registerPage.verifyTitle();
    }

    @Then("user enters {string} in the givenName input")
    public void user_enters_in_the_given_name_input(String givenName) {
        registerPage.enterGivenName(givenName);
    }

    @Then("user enters {string} in the familyName input")
    public void user_enters_in_the_family_name_input(String familyName) {
        registerPage.enterFamilyName(familyName);
        registerPage.clickOnNextBtn();
    }

    @Then("user selects gender in the gender checkbox")
    public void user_selects_in_the_gender_checkbox() {
        registerPage.selectMaleGender();
        registerPage.clickOnNextBtn();
    }

    @Then("user enters {string} in the dayOfBirth input")
    public void user_enters_in_the_day_of_birth_input(String dayOfBirth) {
        registerPage.enterBirthDay(dayOfBirth);
    }

    @Then("user selects month of birth in the monthOfBirth checkbox")
    public void user_selects_in_the_month_of_birth_checkbox() {
        registerPage.selectBirthMonth();
            }

    @Then("user enters {string} in the yearOfBirth input")
    public void user_enters_in_the_year_of_birth_input(String yearOfBirth) {
        registerPage.enterBirthYear(yearOfBirth);
        registerPage.clickOnNextBtn();
    }

    @Then("user enters {string} in the address input")
    public void user_enters_in_the_address_input(String address) {
        registerPage.enterAddress(address);
        registerPage.clickOnNextBtn();
    }

    @Then("user enters {string} in the phone input")
    public void user_enters_in_the_phone_input(String phone) {
        registerPage.enterPhone(phone);
        registerPage.clickOnNextBtn();
    }

    @Then("user selects relationship type in the reletionship_type checkbox")
    public void user_selects_in_the_reletionship_type_checkbox() {
        registerPage.selectRelationshipType();
        registerPage.clickOnNextBtn();
    }

    @When("user clicks on the confirm button")
    public void user_clicks_on_the_confirm_button() {
        registerPage.clickOnConfirmBtn();
    }

    @Then("user should be registered successful and be navigated to patient page")
    public void user_should_be_registered_successful_and_be_navigated_to_patient_page() {
        patientPage = new PatientPage(driver);
        patientPage.verifyTitle();
    }
    @And("user should be verify Patient is successfully added tooltip on top right, it must mutch {string} {string}")
    public void userShouldBeVerifyPatientIsSuccessfullyAddedTooltipOnTopRightItMustMutch(String givenName, String familyName) throws InterruptedException {
        patientPage.verifyPatientCreatedMsg(givenName, familyName);
    }

    @And("user must check the given name, it must match {string}")
    public void userMustCheckTheGivenNameItMustMatch(String givenName) {
        patientPage.verifyPatientGivenName(givenName);
    }

    @And("user must check the family name, it must match {string}")
    public void userMustCheckTheFamilyNameItMustMatch(String familyName) {
        patientPage.verifyPatientFamilyName(familyName);
    }

    @And("user must check the gender, it must match {string}")
    public void userMustCheckTheGenderItMustMatch(String male) {
        patientPage.verifyPatientGender(male);
    }

    @And("user must check the dob, it must match {string}.{string}.{string}")
    public void userMustCheckTheDobItMustMatch(String day, String month, String year) {
        patientPage.verifyDob(day,month,year);
    }

    @And("user should be verify patient id")
    public void userShouldBeVerifyPatientId() throws IOException {
        patientPage.verifyPatientId();
        patientPage.getPatientId();
    }

    @And("user should click on sticky note and enter a  message and click on check")
    public void userShouldClickOnStickyNoteAndEnterAMessageAndClickOnCheck() {
        patientPage.clickonStickynotelink();
        patientPage.enterTextInNoteArea();
        patientPage.clickOnCheckNoteBtn();
    }

    @And("user should be verify sticky note has been displayed")
    public void userShouldBeVerifyStickyNoteHasBeenDisplayed() {
        patientPage.verifyNoteText();
    }

    @And("user should be verify general actions section")
    public void userShouldBeVerifyGeneralActionsSection() {
        patientPage.verifyGeneralActionsMenu();
    }



}
