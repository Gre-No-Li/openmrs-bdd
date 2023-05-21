 @regression
Feature: OpenMRS Registration Feature

  Background: Login Background Steps
    Given this user is on the login page

  Scenario Outline: Successful registration
    When this user enters a valid username "Admin"
    And this user enters a valid password "Admin123"
    And this user clicks on the login button
    Then this user should be logged in successfully and user should be navigated to Home page
    When this user clicks on Register a patient button
    Then user should be navigated to a register patient page
    And user enters "<given_name>" in the givenName input
    And user enters "<family_name>" in the familyName input
    And user selects gender in the gender checkbox
    And user enters "<day_of_birth>" in the dayOfBirth input
    And user selects month of birth in the monthOfBirth checkbox
    And user enters "<year_of_birth>" in the yearOfBirth input
    And user enters "<address>" in the address input
    And user enters "<phone>" in the phone input
    And user selects relationship type in the reletionship_type checkbox
    When user clicks on the confirm button
    Then user should be registered successful and be navigated to patient page
    And user must check the given name, it must match "<given_name>"
    And user must check the family name, it must match "<family_name>"
    And user must check the gender, it must match "Male"
    And user must check the dob, it must match "<day_of_birth>"."Mar"."<year_of_birth>"
    And user should be verify patient id
    And user should click on sticky note and enter a  message and click on check
    And user should be verify sticky note has been displayed
    And user should be verify general actions section

    Examples:
      | given_name | family_name | day_of_birth | year_of_birth | address            | phone     |
      | Chris      | Wade        | 23           | 1988          | 678 Gelding street | 123703456 |

