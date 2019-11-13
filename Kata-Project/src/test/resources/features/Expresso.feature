Feature: General expresso business rules

  Scenario: Normal espresso is singly counted in stats
    Given clean statistic repository
    When create single espresso 1 times
    Then 1 espresso in statistics

  Scenario: Double espresso is double counted in stats
    Given clean statistic repository
    When create double espresso 1 times
    Then 2 espresso in statistics

  Scenario: make two different types of espresso
    Given clean statistic repository
    When create single espresso 1 times
    And create double espresso 1 times
    Then 3 espresso in statistics