
Feature: As a data consumer, I want the user information are stored in mySql DB
  correctly in users table.
  Background:
    Given Establish the database connection

  Scenario: verify users table columns
    Given Establish the database connection
    When Execute query to get all columns
    Then verify the blow columns are listed in result:

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |