Feature: As a librarian, I want to know all the students who brewed books

  Scenario: verify who borrowed which books
    Given Establish the database connection
    When I execute query to full join books and book_categories on user_id
    Then verify the data result set