Feature: End to End test for Gist

  Scenario: Login to Gists
    Given Open Gists page
    Then User click Sign in
    And User input "chintyays" on username field
    And User input "cookie03201997" on password field
    And User click button Sign in

  Scenario: Create a public gists with single file
    When User open create new gist page
    Then User input "Testing" on Gists description field
    Then User input "Test.java" on "first" Filename field
    And User input "Testing Testing Testing" on "first" text box
    And User click button Create public gists
    Then System display gist with title "Test.java"

  Scenario: Create a public gists with multiple file
    When User open create new gist page
    Then User input "Testing2" on Gists description field
    And User input "Test2.java" on "first" Filename field
    And User input "Testing Testing Testing" on "first" text box
    Then User click button Add file
    Then User input "Test3.java" on "second" Filename field
    And User input "Testing Testing Testing" on "second" text box
    And User click button Create public gists
    Then System display gist with title "Test2.java"

  Scenario: Create a private gists with single file
    When User open create new gist page
    Then User input "Testing Secret Gists" on Gists description field
    And User input "gist_secret_single.txt" on "first" Filename field
    And User input "Testing Testing Testing" on "first" text box
    And User click button Create secret gists
    Then System display gist with title "gist_secret_single.txt"

  Scenario: Create a gists with multiple file
    When User open create new gist page
    Then User input "Testing Secret Gists Multiple" on Gists description field
    And User input "gist_secret_multiple.txt" on "first" Filename field
    And User input "Testing Testing Testing" on "first" text box
    Then User click button Add file
    Then User input "Testing Secret Gists Multiple-2.java" on "second" Filename field
    And User input "Testing Testing Testing" on "second" text box
    And User click button Create public gists
    Then System display gist with title "Testing Secret Gists Multiple-2.java"

  Scenario: Edit filename existing secret gists with multiple file but canceled
    Given User on "Testing Secret Gists Multiple-2.java" detail gists page
    Then User click button Edit
    And User update "Edit Testing Secret Gists Multiple-2.java" on Filename field
    And User click button Cancel
    Then System display gist with title "Testing Secret Gists Multiple-2.java"

  Scenario: Edit filename existing secret gists with multiple file
    Given User on "Testing Secret Gists Multiple-2.java" detail gists page
    Then User click button Edit
    And User update "Edit Testing Secret Gists Multiple-2.java" on Filename field
    And User click button Update public gist
    Then System display gist with title "Edit Testing Secret Gists Multiple-2.java"

  Scenario: Delete an existing secret gists
    Given User on "Edit Testing Secret Gists Multiple-2.java" detail gists page
    When User click button Delete
    And User click "OK" on popup notification
    Then System display message "Gist deleted successfully."

  Scenario: See my list of gists
    When User open home page to see all my lists of gists










