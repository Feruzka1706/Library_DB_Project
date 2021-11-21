package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Feature03_StepDef {

    String actualResult;


    @When("I execute query to left outer inner join books and book_borrow on Book_Id")
    public void i_execute_query_to_left_outer_inner_join_books_and_book_borrow_on_book_id() {
        String query="select bc.name,count(*) from book_borrow bb inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by bc.name\n" +
                "order by 2 desc";
        DB_Util.runQuery(query);

        actualResult=DB_Util.getFirstRowFirstColumn();
        System.out.println("actualResult = " + actualResult);
    }


    @Then("verify {string} is the most popular book genre")
    public void verify_what_is_the_most_popular_book_genre(String expectedResult) {

        Assertions.assertEquals(expectedResult,actualResult);
        System.out.println("expectedResult = " + expectedResult);
    }



}
