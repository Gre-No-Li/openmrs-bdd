 @regression
Feature: OpenMRS Login Feature

  Background: Login Background Steps
    Given user is on the login page

    @smoke
  Scenario: Successful login
    When user enters a valid username "Admin"
    And user enters a valid password "Admin123"
    And user clicks on the login button
    Then user should be logged in successfully and user should be navigated to Home page

  Scenario: Invalid credentials
    When user enters a valid username "Admin"
    And user enters an invalid password "123Admin"
    And user clicks on the login button
    Then user should see an error message "Invalid username/password. Please try again."