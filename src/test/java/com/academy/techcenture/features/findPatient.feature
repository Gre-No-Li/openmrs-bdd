Feature: OpenMRS Find Patient Feature

  Background: Login Background Steps
    Given user is on the login page

  Scenario: Successful login
    When user enters a valid username "Admin"
    And user enters a valid password "Admin123"
    And user clicks on the login button
    Then user should be logged in successfully and be navigated to the Home page
    When user clicks on 'Find Patient Record' button
    Then user should be navigated to find patient page
    And user enters patient's ID in the search by ID input
    And user verify the result shows up on the table
    When user clicks on OpenMRS button
    Then user should be navigated to the Home Page
