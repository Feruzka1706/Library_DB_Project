package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Feature07_Page {

    public Feature07_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[@role='button']")
    public WebElement borrowBooks;

     @FindBy(xpath = "//div[@id='toast-container']//div[@class='toast-message']")
    public WebElement toastMessage;

     @FindBy(xpath = "//*[@id='borrowed_list']/tbody/tr/td[2]")
    public List<WebElement> lastRowInfo;

     @FindBy(xpath = "//*[@id='borrowed_list']/tbody/tr/td[6]")
    public List<WebElement> notReturnedMsg;


}
