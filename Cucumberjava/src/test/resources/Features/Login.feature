Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given User is on login page
    When user enter username and password
    And click on login button
    Then User is navigated to homepage

 