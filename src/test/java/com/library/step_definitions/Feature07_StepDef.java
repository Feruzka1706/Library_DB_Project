package com.library.step_definitions;

import com.library.pages.Feature05_Page;
import com.library.pages.Feature07_Page;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Feature07_StepDef {
    Feature05_Page feature05Page=new Feature05_Page();
    Feature07_Page feature07_page=new Feature07_Page();
    String bookName;
    String bookAuthor;

    String expectedBorrowedBookName;
    String expectedResultBorrowMsg;


    @Given("I login as a student to library app")
    public void i_login_as_a_student_to_library_app() {
        Driver.getDriver().get(ConfigReader.read("library_url"));
        BrowserUtil.waitFor(2);
        feature05Page.login(ConfigReader.read("username_3"),ConfigReader.read("password"));
        BrowserUtil.waitFor(3);
    }


    @Given("search book name called {string}")
    public void search_book_name_called(String bookName) {
        BrowserUtil.waitFor(2);
        new Actions(Driver.getDriver()).click(feature05Page.searchBookBox).pause(2000).sendKeys(bookName).perform();
        BrowserUtil.waitFor(2);
        this.bookName=feature05Page.bookName.getText();
        bookAuthor=feature05Page.bookAuthor.getText();

    }


    @When("I click borrow book")
    public void i_click_borrow_book() {
        BrowserUtil.waitFor(2);
        feature07_page.borrowBooks.click();
        BrowserUtil.waitForElementIsNotLocated(feature07_page.toastMessage);
        Assertions.assertTrue(feature07_page.toastMessage.isDisplayed());
        System.out.println(feature07_page.toastMessage.getText());

        BrowserUtil.waitFor(3);
    }

    @Then("I verify that book is shown in {string} page")
    public void i_verify_that_book_is_shown_in_page(String pageName) {
       feature05Page.clickModule(pageName);
       BrowserUtil.waitFor(3);
       expectedBorrowedBookName=feature07_page.lastRowInfo.get(feature07_page.lastRowInfo.size()-1).getText();
       expectedResultBorrowMsg=feature07_page.notReturnedMsg.get(feature07_page.notReturnedMsg.size()-1).getText();

    }


    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        String query="select b.name from book_borrow bb inner join books b on b.id = bb.book_id\n" +
                "where b.name='Java OOP Concepts' and bb.returned_date is null";

        DB_Util.runQuery(query);
        String actualBorrowedBookName=DB_Util.getFirstRowFirstColumn();

        Assertions.assertEquals(expectedBorrowedBookName,actualBorrowedBookName);
    }

}
