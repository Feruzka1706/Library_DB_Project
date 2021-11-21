package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Feature01_StepDefs {

   Set<String> expectedList=new LinkedHashSet<>();
   List<String> actualListFromDB=new ArrayList<>();

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
      String query="select id from users";
        DB_Util.runQuery(query);

        actualListFromDB=DB_Util.getColumnDataAsList(1);
        expectedList.addAll(actualListFromDB);
        //System.out.println("expectedList = " + expectedList);
        //System.out.println("actualListFromDB = " + actualListFromDB);
    }


    @Then("verify all users has unique ID")
    public void verify_the_result_set() {

        Assert.assertEquals(expectedList.size(),actualListFromDB.size());

    }

   List<String> actualColumnList=new ArrayList<>();
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        String query="select * from users";
        DB_Util.runQuery(query);
        actualColumnList=DB_Util.getAllColumnNamesAsList();

    }


    @Then("verify the blow columns are listed in result:")
    public void verify_the_blow_columns_are_listed_in_result(List<String> expectedColumnList) {

        Assert.assertEquals(expectedColumnList,actualColumnList);
        System.out.println("expectedColumnList = " + expectedColumnList);
        System.out.println("actualColumnList = " + actualColumnList);

    }



}
