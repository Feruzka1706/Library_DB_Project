@us4
Feature: As a librarian, I want to know all the students who brewed books

  @db
  Scenario: verify who borrowed which books
    Given Established DB connection
    When I execute query to full join books and book_categories on user_id
    Then verify "Test Student 344" the user who reads the most