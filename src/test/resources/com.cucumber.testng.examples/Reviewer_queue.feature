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
  Scenario Outline: Validate the Status Filter
    Given User is on the queue <queue>
    When User selects Filter by <Filter>
    And User selects the status <Status>
    Then Only the firms showed with <Status>
    And check the fields displayed within a firm

    Examples: 
      | Filter          | Status             | queue  |
      | Status          | All                | REVIEW |
      | Status          | READY TO REVIEW    | REVIEW |
      | Status          | REVIEW IN PROGRESS | REVIEW |
      | Type            | All                | REVIEW |
      | Type            | PE                 | REVIEW |
      | Last Updated By | All                | REVIEW |
      | Last Updated By | mlopez             | REVIEW |
      | Last Updated By | rarodriguez        | REVIEW |

  @regression @positive @reviewerqueue
  Scenario Outline: Validate the Sort Filter
    Given User is on the queue <queue>
    When User selects Sort by <Sorting>
    And User selects the criteria <Criteria>
    Then Only the firms showed with <Sorting>
    And check the fields Sorted within a firm

    Examples: 
      | Sorting         | Criteria   | queue  |
      | Number of Funds | Ascending  | REVIEW |
      | Number of Funds | Descending | REVIEW |
      | Firm Name       | A-Z        | REVIEW |
      | Firm Name       | Z-A        | REVIEW |
      | Submitted Date  | Ascending  | REVIEW |
      | Submitted Date  | Descending | REVIEW |
