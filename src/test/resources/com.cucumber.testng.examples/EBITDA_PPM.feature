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
Feature: Report validation
  This suite is to validate the Reports information showed

  Background: Login with a Reviewer valid user
    When User enters a Reviewer valid user name
    And User enters a Reviewer valid password
    And User clicks in the Login button
    And Clicks into the alert page
    Then user shall be redirected to the OM main page

  @regression @positive @Reports
  Scenario Outline: Validate the report
    Given User selects Report Section <Section>
    When User is in Report Type <Report Type>
    And User selects Report to be showed <Report>
    And User clicks on Run button
    Then The report displayed is <Report>
    And check the values showed

    Examples: 
      | Section         | Report Type | Report         |
      | Defined Reports | EBITDA PPM  | Total Universe |
      | Defined Reports | EBITDA PPM  | Company Type   |
      | Defined Reports | EBITDA PPM  | Sector         |
      | Defined Reports | EBITDA PPM  | ExitAnalisys   |
