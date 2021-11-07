package com.library.step_definitions;

import com.library.utility.ConfigReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    /**
     * This @Before  for UI part
     */
    @Before
    public void setupDriver() {

        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can add maximize browser if you want to do it
        // Driver.getDriver().manage().window().maximize();
    }




    /**
     * This @After for UI part
     * @param scenario
     */
    @After
    public void tearDown(Scenario scenario) {

        // check if scenario failed or not
        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // scenario.attach(screenshot,"image/png","what ever we want");
            scenario.attach(screenshot,"image/png","Image for failed step");
        }
        Driver.closeBrowser();
    }


}
