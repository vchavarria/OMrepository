Feature: OMTest
  This is the suite for OM Project
  
  @regression @login @positive
  Scenario: Login with a valid user
  When User enters a valid user name
  And User enters a valid password 
  Then user shall be redirected to the OM main page 
  
  @regression @login @negative
  Scenario: Login with a invalid user
  When User enters an invalid user name
  And User enters a valid password 
  Then error message shall be showed 
  
  @regression @login @negative
  Scenario: Login with a invalid password
  When User enters a valid user name
  And User enters an invalid password 
  Then error message shall ba showed 
  
  @basictest
  Scenario: Validate the header
    When Navigate to OM site
    Then Header shall be "OPERATING METRICS"

  @basictest
  Scenario: Reviewing the table headers
    When Navigate to OM site
    Then I should be see the table header "Qualitative Company Details"

  @basictest
  Scenario: Updating Notes field
    When Navigate to OM site
    And user double clicks in Company notes
    Then User is able to enter "Company note here for 401 test"
    And user shall be able to click in save button

  @wip
  Scenario Outline: Validate Qualitative Company details Fields
    When Navigate to OM site
    And pass the xpath locator <xpath>
    Then OMUser is able to see the <Fields>

    Examples: 
      | Fields        | xpath                                  |
      | Notes         | //div[3]/div/div[2]/div/div[2]/span[5] |
      | GICS Sector   | //div[2]/div[2]/span[5]                |
      | GICS Industry | //div[3]/div[2]/span[5]                |
