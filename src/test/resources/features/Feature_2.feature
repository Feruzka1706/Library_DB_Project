@us2
Feature: As a librarian, I want to know who borrowed books

  @ui @db
  Scenario: verify the amount of people who borrowed books
    Given I am in the homepage of library app
    When I take borrowed books amount
    Then borrowed books amount information must match with database information
