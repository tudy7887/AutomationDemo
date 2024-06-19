Feature: Register Functionality
  In order to access the app you must be registered
  As a new user
  I want to register successfully

  Scenario Outline: Register as customer
    Given I am on the register page
    When I enter first name = <firstname>, last name = <lastname>, phone = <phone>, email = <email>, password = <password>, city = <city>
    And Check the customer checkbox
    And I click on Sign Up button
    Then I should be taken to the Login page
    Examples:
      |firstname|lastname |phone      |email               |password     |city  |
      |"tudor"  |"niculae"|"0757690534"|"tudor7@niculae.com"|"parola123.C"|"Cluj"|

  Scenario Outline: Register as trainer
    Given I am on the register page
    When I enter first name = <firstname>, last name = <lastname>, phone = <phone>, email = <email>, password = <password>, city = <city>
    And Check the trainer checkbox
    And I click on Sign Up button
    Then I should be taken to the Login page
    Examples:
      |firstname|lastname |phone      |email               |password     |city  |
      |"tudor"  |"niculae"|"0757690533"|"tudor8@niculae.com"|"parola123.T"|"Cluj"|

  Scenario Outline: Fail to register as customer
    Given I am on the register page
    When I enter first name = <firstname>, last name = <lastname>, phone = <phone>, email = <email>, password = <password>, city = <city>
    And Check the customer checkbox
    And I click on Sign Up button
    Then I should remain on Register page and receive the following error meage: <error>
    Examples:
      |firstname|lastname |phone      |email               |password     |city  |error                                          |
      |"tudor"  |"niculae"|"123123123"|"tudor9@niculae.com"|"parola123.C"|"Cluj"|"Customer already registered with this number!"|