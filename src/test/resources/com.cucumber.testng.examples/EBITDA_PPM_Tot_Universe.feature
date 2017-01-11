#Author: Victor Chavarria
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: OM EBITDA PPM Total Universe report validation
  This suite is to validate the EBITDA PPM Total Universe Report

  Background: Login with a Reviewer valid user
    When User enters a Reviewer valid user name
    And User enters a Reviewer valid password
    And User clicks in the Login button
    And Clicks into the alert page
    Then user shall be redirected to the OM main page

  @regression @positive @EBITDAPPMTU
  Scenario Outline: Validate the PPM Total Universe report
    Given User is on the Section <Section>
    When User selects Type Report <Report Type>
    And User selects Report <Report>
    And User clicks on Run button
    Then <Report> is showed 
    And check the values showed

    Examples: 
      | Section         | Report Type | Report         |
      | Defined Reports | EBITDA PPM  | Total Universe |
