
Feature: Books module
  As a student, I should be able to borrow book

Scenario: Student borrow new book
  Given I login as a student
  And I navigate to "Books" page
  And search book name called "You can borrow any book"
  When I click borrow book
  Then I verify that book is shown in "Borrowing Books" page
  And verify logged student has same book in database