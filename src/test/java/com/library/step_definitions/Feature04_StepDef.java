package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Feature04_StepDef {
    String actualPopularUser;

    @When("I execute query to full join books and book_categories on user_id")
    public void i_execute_query_to_full_join_books_and_book_categories_on_user_id() {
        String query="select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id\n" +
                "group by full_name\n" +
                "order by 2 desc";
        DB_Util.runQuery(query);
        actualPopularUser=DB_Util.getFirstRowFirstColumn();
        System.out.println("actualPopularUser = " + actualPopularUser);

    }

    @Then("verify {string} the user who reads the most")
    public void verify_the_user_who_reads_the_most(String expectedPopularUser) {
        Assertions.assertEquals(expectedPopularUser,actualPopularUser);
        System.out.println("actualPopularUser = " + actualPopularUser);

    }


}
