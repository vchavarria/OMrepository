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
#This is a test to work with Sourcetree


Feature: Login functionality

 @regression @login @positive
  Scenario: Login with a Reviewer valid user
  When User enters a valid user name
  And User enters a valid password 
  Then user shall be redirected to the OM main page 
  
  @regression @login @negative
  Scenario: Login with a Reviewer invalid user
  When User enters an invalid user name
  And User enters a valid password 
  Then error message shall be showed 
  
  @regression @login @negative
  Scenario: Login with a Reviewer invalid password
  When User enters a valid user name
  And User enters an invalid password 
  Then error message shall be showed 
  
   @regression @login @positive
  Scenario: Login with a Quality Checker valid user
  When User enters a valid user name
  And User enters a valid password 
  Then user shall be redirected to the OM main page 
  
  @regression @login @negative
  Scenario: Login with a Quality Checker invalid user
  When User enters an invalid user name
  And User enters a valid password 
  Then error message shall be showed 
  
  @regression @login @negative
  Scenario: Login with a Quality Checker invalid password
  When User enters a valid user name
  And User enters an invalid password 
  Then error message shall be showed 