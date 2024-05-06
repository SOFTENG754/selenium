Feature: Addition Calculator

  Background:
    Given I open the calculator page

  Scenario Outline: Addition of two numbers
    Given I enter <firstNumber> into the calculator
    And I also enter <secondNumber> into the calculator
    When I press add
    Then the result should be <sum>

    Examples:
      | firstNumber | secondNumber | sum |
      |           5 |           10 |  15 |
      |          10 |            0 |  10 |
      |          -5 |           10 |  5 |