package com.library.step_definitions;

import com.library.pages.Feature06_Page;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Feature06_StepDef {

 Feature06_Page feature06_page=new Feature06_Page();

   List<String> expectedBookOptions=new ArrayList<>();
   List<String> actualBookCategories=new ArrayList<>();

    @When("I take all book categories in webpage")
    public void i_take_all_book_categories_in_webpage() {
        BrowserUtil.waitFor(3);
        feature06_page.bookCategories.click();
        BrowserUtil.waitFor(2);
        Select select=new Select(feature06_page.bookCategories);
        expectedBookOptions=BrowserUtil.getElementsText(select.getOptions());
         expectedBookOptions.remove(0);
        System.out.println("expectedBookOptions = " + expectedBookOptions);
        BrowserUtil.waitFor(2);

    }

    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        String query="select name from book_categories";
        DB_Util.runQuery(query);
        actualBookCategories=DB_Util.getColumnDataAsList(1);
        System.out.println("actualBookCategories = " + actualBookCategories);

    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        Assertions.assertEquals(expectedBookOptions,actualBookCategories);
    }


}
