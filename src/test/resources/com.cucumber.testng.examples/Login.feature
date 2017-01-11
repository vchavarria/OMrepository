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
	When User enters a Reviewer valid user name 
	And User enters a Reviewer valid password 
	And User clicks in the Login button 
	And Clicks into the alert page 
	Then user shall be redirected to the OM main page 
	
@regression @login @negative 
Scenario: Login with a Reviewer invalid user 
	When User enters a Reviewer invalid user name 
	And User enters a Reviewer valid password 
	And User clicks in the Login button 
	Then error message "Sign in failed!" shall be showed 
	
@regression @login @negative 
Scenario: Login with a Reviewer invalid password 
	When User enters a Reviewer valid user name 
	And User enters an Reviewer invalid password 
	And User clicks in the Login button 
	Then error message "Sign in failed!" shall be showed 
	
@regression @login @positive 
Scenario: Login with a Quality Checker valid user 
	When User enters a valid QC user name 
	And User enters a QC valid password 
	And User clicks in the Login button 
	And Clicks into the alert page 
	Then user shall be redirected to the OM main page 
	
@regression @login @negative 
Scenario: Login with a Quality Checker invalid user 
	When User enters a QC invalid user name 
	And User enters a QC valid password 
	And User clicks in the Login button 
	Then error message "Sign in failed!" shall be showed 
	
@regression @login @negative 
Scenario: Login with a Quality Checker invalid password 
	When User enters a QC valid user name 
	And User enters a QC invalid password 
	And User clicks in the Login button 
	Then error message "Sign in failed!" shall be showed 