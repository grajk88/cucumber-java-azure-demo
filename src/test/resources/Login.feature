@login
Feature: Login into Zero Web Security application

  @smoke @regression
  Scenario: Successful Login
    Given I am in the login page 
    When I enter valid credentials
    Then I should be able to login successfully
   
  @regression
  Scenario: Successful Login
    Given I am in the login page 
    When I enter valid credentials
    Then I should be able to login successfully
    
  @regression
  Scenario: Successful Login
    Given I am in the login page 
    When I enter valid credentials
    Then I should be able to login successfully
