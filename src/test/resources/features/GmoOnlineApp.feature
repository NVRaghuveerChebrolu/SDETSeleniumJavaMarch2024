@Regression
Feature: Validate GmoOnline Application


Background:
Given User is on login page of GMO Online App

@Regression
  Scenario: ValidateEndtoEndFlow
    Given I click on GmoOnline Login Page 
    When I add quantity for hiking boots product
    And user clicks on submit button
    Then I validate the place order page is displayed


