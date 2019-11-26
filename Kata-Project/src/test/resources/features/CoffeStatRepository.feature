Feature: General coffe statistic repository rules

  Scenario: The repository should have zeroed statistics after reset
    Given not empty repository
    When reset repository
    Then repository is empty