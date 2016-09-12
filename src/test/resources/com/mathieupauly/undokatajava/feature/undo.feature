Feature: Undo command
  Scenario: Append
    Given append has been performed
    And the buffer printed "Hello world"
    When writer performs undo command
    Then the buffer should print "Hello worl"
  Scenario: No history
    Given no operation has been performed
    And the buffer printed "Hello world"
    When writer performs undo command
    Then the buffer should print "Hello world"
