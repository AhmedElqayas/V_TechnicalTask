Feature: Create New Account User

  In order to use the site capabilities
  As a new user of the website
  I need to create an account


  Scenario: create new user successfully
    Given the user at the website authentication page
    When the user enters a valid email
    Then the user can create a new user account



