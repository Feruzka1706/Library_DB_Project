package com.library.pages;

import com.library.utility.BrowserUtil;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Feature05_Page {

    public Feature05_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement inputUserName;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(xpath = "//div//input[@type='search']")
    public WebElement searchBookBox;

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement bookName;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement bookAuthor;

    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    public WebElement bookYear;

    @FindBy(xpath = "//thead//th[3][@rowspan='1']")
    public WebElement headerOfName;

    @FindBy(xpath = "//thead//th[4][@rowspan='1']")
    public WebElement headerOfAuthor;

    @FindBy(xpath = "//thead//th[6][@rowspan='1']")
    public WebElement headerOfYear;






    public void login(String userName, String password){

        inputUserName.sendKeys(userName);
        BrowserUtil.waitFor(2);
        inputPassword.sendKeys(password);
        BrowserUtil.waitFor(2);
        loginButton.click();

    }

    public void clickModule(String moduleName){
     WebElement moduleOption=Driver.getDriver().
             findElement(By.xpath("//ul/li[@class='nav-item']//span[text()='"+moduleName+"']"));
     moduleOption.click();

    }





}
