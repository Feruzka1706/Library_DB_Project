package com.library.step_definitions;

import com.library.pages.Feature05_Page;
import com.library.utility.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

import java.util.LinkedHashMap;
import java.util.Map;

public class Feature05_StepDef {
    //declaring the object at class level, so we can access in each code snippets by calling it
   Feature05_Page feature05Page =new Feature05_Page();
   Map<String,String> expectedBookInfo=new LinkedHashMap<>();
   Map<String,String> actualBookInfo=new LinkedHashMap<>();

   String bookInfoQuery="select name, author, year from books where name='Harry Potter' and author='Djoan Rowling'";


    @Given("I am in the homepage of library app")
    public void i_am_in_the_homepage_of_library_app() {
        Driver.getDriver().get(ConfigReader.read("library_url"));
        BrowserUtil.waitFor(2);
        feature05Page.login(ConfigReader.read("username_1"),
                ConfigReader.read("password"));

        BrowserUtil.waitFor(3);

    }


    @When("I navigate to {string} page")
    public void i_navigate_to_page(String string) {

        feature05Page.clickModule(string);
        BrowserUtil.waitFor(3);

    }

     String bookName;
    @When("I open a book called {string}")
    public void i_open_a_book_called_harry_potter(String book) {
        bookName=book;
        new Actions(Driver.getDriver()).click(feature05Page.searchBookBox)
                .pause(2000).sendKeys(bookName).perform();

        BrowserUtil.waitFor(2);
        //we are adding inside expected result Map the book info from UI part, book table
        //so table headers will be key and rows info will be values
        expectedBookInfo.put(feature05Page.headerOfName.getText().toLowerCase(),feature05Page.bookName.getText());
        expectedBookInfo.put(feature05Page.headerOfAuthor.getText().toLowerCase(),feature05Page.bookAuthor.getText());
        expectedBookInfo.put(feature05Page.headerOfYear.getText().toLowerCase(),feature05Page.bookYear.getText());

        System.out.println(expectedBookInfo);

        BrowserUtil.waitFor(3);

    }


     @When("Established DB connection")
    public void i_established_db_connection() {

         System.out.println("*******************************************");
         System.out.println("***** Connection is DONE via HOOKS ********");
         System.out.println("*******************************************");

     }


    @When("I execute query to get the book information from books table")
    public void i_execute_query_to_get_the_book_information_from_books_table() {
        DB_Util.runQuery(bookInfoQuery);
        //we are adding inside actual result Map from database table first column and all rows from first column
        actualBookInfo=DB_Util.getRowMap(1);

        System.out.println(actualBookInfo);

    }


    @Then("verify book DB and UI information must match")
    public void verify_book_db_and_ui_information_must_match() {

        Assertions.assertEquals(expectedBookInfo,actualBookInfo);

    }





}
