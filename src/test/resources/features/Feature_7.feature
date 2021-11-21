@us7
Feature: Books module
  As a student, I should be able to borrow book

  @ui @db
Scenario: Student borrow new book
  Given I login as a student to library app
  And I navigate to "Books" page
  And search book name called "Java OOP Concepts"
  When I click borrow book
  Then I verify that book is shown in "Borrowing Books" page
  And verify logged student has same book in database