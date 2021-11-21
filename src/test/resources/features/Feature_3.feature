@us3
Feature: As a librarian, I want to know genre of books are being borrowed the most

  @db
  Scenario: verify the the common book genre that’s being borrowed
    Given Established DB connection
    When I execute query to left outer inner join books and book_borrow on Book_Id
    Then verify "Action and Adventure" is the most popular book genre


    #"select  bc.name ,count(bb.book_id) from book_categories bc\n" +
    #                "inner join books b on bc.id = b.book_category_id\n" +
    #                "inner join book_borrow bb on b.id = bb.book_id\n" +
    #                "group by bc.name\n" +
    #                "order by 2 DESC "