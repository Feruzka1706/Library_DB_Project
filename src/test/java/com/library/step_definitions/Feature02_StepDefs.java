package com.library.step_definitions;

import com.library.pages.Feature02_Page;
import com.library.pages.Feature05_Page;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Feature02_StepDefs {

    Feature02_Page feature02Page =new Feature02_Page();
    String expectedBookCount;
    String actualBookCount;

    @When("I take borrowed books amount")
    public void i_take_borrowed_books_amount() {
        expectedBookCount = feature02Page.borrowedBookCount.getText();
    }


    @Then("borrowed books amount information must match with database information")
    public void borrowed_books_amount_information_must_match_with_database_information() {
       String query="select count(*) from book_borrow where returned_date is null";

       DB_Util.runQuery(query);
       actualBookCount= DB_Util.getFirstRowFirstColumn();

        Assertions.assertEquals(expectedBookCount,actualBookCount);
        System.out.println("expectedBookCount = " + expectedBookCount);
        System.out.println("actualBookCount = " + actualBookCount);

    }




}
