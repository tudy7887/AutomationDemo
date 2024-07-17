Feature: Accounts Operations

  Scenario: Create a new account
    Given I'm a Para Bank user with N accounts; main account on the first position
    When I go to create a new account page
    And Fill the data
    And Click on Create New Account
    Then I should see the new created account
    And Now I should have one more account
    And Last account should be the newly created one

  Scenario Outline: Transfer between accounts
    Given I'm a Para Bank user with at least 2 accounts; I wanna transfer between first 2 accounts
    When I go Transfer funds
    And Insert "<amount>" to Amount, chose first account as From and chose second account as To
    And Click on Transfer
    Then I should see a confirmation message of the "<amount>"$ transaction
    And Last transaction on first account is "<amount>" Debit
    And Last transaction on second account is "<amount>" Credit
    Examples:
      |amount|
      |10    |
      |50    |
      |100   |