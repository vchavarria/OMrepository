Feature: OMTest
  This is the suite for OM Project
  
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
