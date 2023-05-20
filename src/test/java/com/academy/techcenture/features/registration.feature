Feature: OpenMRS Registration Feature

  Background: Login Background Steps
    Given user is on the login page

  Scenario: Successful registration
    When user enters a valid username "Admin"
    And user enters a valid password "Admin123"
    And user clicks on the login button
    Then user should be logged in successfully and be navigated to the Home page
    When user clicks on 'Register a patient' button
    Then user should be navigated to a register patient page
    And user enters "<given_name>" in the givenName input
    And user enters "<family_name>" in the familyName input
    And  user selects "<gender>" in the gender checkbox
    And user enters "<day_of_birth>" in the dayOfBirth input
    And user selects "<month_of_birth>" in the monthOfBirth checkbox
    And user enters "<year_of_birth>" in the yearOfBirth input
    And user enters "<address>" in the address input
    And user enters "<phone>" in the phone input
    And user selects "<relationship_type>" in the reletionship_type checkbox
    And user enters "<person_name>" in the personName input
    When user clicks on the confirm button
    Then user should be registered successful and be navigated to patient page

