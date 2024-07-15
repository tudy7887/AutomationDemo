Feature: Login Functionality

  Scenario: Login With Wrong Credentials
    Given I am on the login page of the FeTraining Application
    When I enter invalid username = <username> and password = <password>
    And I click on Login Button
    Then I should receive an <error>

  Scenario: Login With Valid Credentials
    Given I am on the login page of the FeTraining Application
    When I enter valid customer username = <username> and password = <password>
    And I click on Login Button
    Then I should be taken to the Customers Dashboard Page