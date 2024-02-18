Feature: Reverse Operators Functionality


  Scenario: Reverse AND operator to OR
    Given a Java code with an IF statement containing an AND operator
    When the reverse operators function is applied
    Then the AND operator should be replaced with an OR operator


  Scenario: Verify compound if statement behavior in the given function
    Given I have a code with compounds if statement
    When  I execute the reverse code
    Then  the code should behave as expected