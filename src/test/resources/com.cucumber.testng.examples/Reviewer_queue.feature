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

  Background: Login with a Reviewer valid user 
	When User enters a Reviewer valid user name 
	And User enters a Reviewer valid password 
	And User clicks in the Login button 
	And Clicks into the alert page 
	Then user shall be redirected to the OM main page 
  
  @regression @positive @reviewerqueue
  Scenario Outline: Validate the Status Filter for PE Funds
    Given User is on the queue <queue>
    When User selects Filter by <Filter>
    And User selects the status <Status>
    Then Only the firms showed with Filter <Status>
    And check the fields displayed within a firm

    Examples: 
      | Filter          | Status                         | queue     |
      | Status          | All                            | REVIEW    |
      | Status          | READY TO REVIEW                | REVIEW    |
      | Status          | REVIEW IN PROGRESS             | REVIEW    |
      | Type            | All                            | REVIEW    |
      | Type            | PE                             | REVIEW    |
      | Type            | RE                             | REVIEW    |
      | Last Updated By | All                            | REVIEW    |
      | Last Updated By | CAMBRIDGEASSOCIATES/VCHAVARRIA | REVIEW    |
      | Last Updated By | System                         | REVIEW    |
     # #| Status          | All                            | EXCEPTION |
      ##| Status          | DUPLICATED                     | EXCEPTION |
      ##| Status          | REJECTED                       | EXCEPTION |
     # #| Type            | All                            | EXCEPTION |
      ##| Type            | PE                             | EXCEPTION |
      ##| Type            | RE                             | EXCEPTION |
     # #| Last Updated By | All                            | EXCEPTION |
     # #| Last Updated By | rrodriguez                     | EXCEPTION |

  @regression @positive @reviewerqueue
  Scenario Outline: Validate the Sort Filter for PE Funds
    Given User is on the queue <queue>
    When User selects Sort by <Sorting>
    And User selects the criteria <Criteria>
    Then Only the firms showed with Sort <Sorting>
    And check the fields Sorted within a firm

    Examples: 
      | Sorting         | Criteria   | queue     |
      | Number of Funds | Ascending  | REVIEW    |
      | Number of Funds | Descending | REVIEW    |
      | Firm Name       | A-Z        | REVIEW    |
      | Firm Name       | Z-A        | REVIEW    |
      | Submitted Date  | Ascending  | REVIEW    |
      | Submitted Date  | Descending | REVIEW    |
      ##| Number of Funds | Ascending  | EXCEPTION |
      ##| Number of Funds | Descending | EXCEPTION |
      ##| Firm Name       | A-Z        | EXCEPTION |
      ##| Firm Name       | Z-A        | EXCEPTION |
      ##| Submitted Date  | Ascending  | EXCEPTION |
     ## | Submitted Date  | Descending | EXCEPTION |
