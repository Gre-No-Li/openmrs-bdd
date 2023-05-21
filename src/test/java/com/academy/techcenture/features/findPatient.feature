Feature: OpenMRS Find Patient Feature

   @regression
  Scenario Outline: Successful Find Patient
      Given patient on the login page
      When patient enters a valid username "Admin"
      And patient enters a valid password "Admin123"
      And patient clicks on the login button
      Then patient should be logged in successfully and user should be navigated to Home page
      When user clicks on Find Patient Record button
      Then user should be navigated to find patient page
      And user enters patient's ID in the search by ID input
      And user must verify the given name, it must match "<given_name>"
      And user must verify the family name, it must match "<family_name>"
      And user must verify the gender, it must match "Male"
      And user must verify the dob, it must match "<day_of_birth>"."Mar"."<year_of_birth>"
      When user clicks on OpenMRS button
      Then user should be navigated to the Home Page

     Examples:
       | given_name | family_name | day_of_birth | year_of_birth |
       | Lebron     | Wade        | 23           | 1988          |
