Feature: Undo command
  Scenario: Append
    Given append has been performed
    And the buffer printed "Hello"
    When writer performs undo command
    Then the buffer should print "Hell"