

Feature: Feature to test Sauce Demo Website

 
  Scenario: Validate Saucedemo website is working
    Given user open a browser
    And user is on saucedemo page
    When user enter username and password field
    And Hit Login Button
  	Then User navigate to Homepage
  	Then Select Filters Options
  	And Adding product to the cart 
  
 
