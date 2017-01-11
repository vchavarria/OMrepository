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
Feature: OM Quality queue validation
  This suite is to validate the Quality queue screen

  Background: Login with a Reviewer valid user
    When User enters a Reviewer valid user name
    And User enters a Reviewer valid password
    And User clicks in the Login button
    And Clicks into the alert page
    Then user shall be redirected to the OM main page

  @regression @positive @qualitycheck
  Scenario Outline: Validate the Status Filter for PE Funds
    Given User is on the queue <queue>
    When User selects Filter by <Filter>
    And User selects the status <Status>
    Then Only the firms showed with Filter <Status>
    And check the fields displayed within a firm

    Examples: 
      | Filter          | Status                         | queue   |
      | Status          | All                            | QUALITY |
      | Status          | READY FOR QC                   | QUALITY |
      | Status          | QC IN PROGRESS                 | QUALITY |
      | Type            | All                            | QUALITY |
      | Type            | PE                             | QUALITY |
      | Type            | RE                             | QUALITY |
      | Last Updated By | All                            | QUALITY |
      | Last Updated By | CAMBRIDGEASSOCIATES/VCHAVARRIA | QUALITY |

  @regression @positive @qualitycheck
  Scenario Outline: Validate the Sort Filter for PE Funds
    Given User is on the queue <queue>
    When User selects Sort by <Sorting>
    And User selects the criteria <Criteria>
    Then Only the firms showed with Sort <Sorting>
    And check the fields Sorted within a firm

    Examples: 
      | Sorting         | Criteria   | queue   |
      | Number of Funds | Ascending  | QUALITY |
      | Number of Funds | Descending | QUALITY |
      | Firm Name       | A-Z        | QUALITY |
      | Firm Name       | Z-A        | QUALITY |
      | Submitted Date  | Ascending  | QUALITY |
      | Submitted Date  | Descending | QUALITY |
