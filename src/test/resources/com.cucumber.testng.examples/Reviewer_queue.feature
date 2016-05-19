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
Feature: OM Reviewer queue validation
  This suite is to validate the Reviewer queue screen

  Background: Valid Reviewer Login
    When User enters a Reviewer valid user name
    And User enters a Reviewer valid password
    And User clicks in the Login button 
    And Clicks into the alert page
    Then user shall be redirected to the OM main page

  @regression @positive @reviewerqueue
  Scenario: Validate the Review in Progress Filter
    Given User is on the Reviewer queue
    When User selects Filter by Status
    And User selects the status REVIEW IN PROGRESS
    Then Only the firms in REVIEW IN PROGRESS are showed
    And check the fields displayed within a firm
    
    @regression @positive @reviewerqueue
  Scenario: Validate the Ready to REview Filter
    Given User is on the Reviewer queue
    When User selects Filter by Status
    And User selects the status READY TO REVIEW
    Then Only the firms in READY TO REVIEW are showed
    And check the fields displayed within a firm
    

    ##Examples: 
      ##| Filter | Status             |
      ##| Status | REVIEW IN PROGRESS |
      ##| Status | READY TO REVIEW    |
