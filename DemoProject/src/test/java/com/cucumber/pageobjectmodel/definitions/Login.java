package com.cucumber.pageobjectmodel.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {


    /**
     * 
     * All WebElements are identified by @FindBy annotation
     * 
     */
 
    WebDriver driver;
 
    @FindBy(name = "txtUsername")
    WebElement userName;
 
    @FindBy(name = "txtPassword")
    WebElement password;
 
    @FindBy(id = "logInPanelHeading")
    WebElement titleText;
 
    @FindBy(id = "btnLogin")
    WebElement login;
 
    public Login(WebDriver driver) {
 
        this.driver = driver;
 
        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
 
    // Set user name in text box
    public void setUserName(String strUserName) {
        userName.sendKeys(strUserName);
    }
 
    // Set password in password textbox
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }
 
    // Click on login button
    public void clickLogin() {
        login.click();
    }
 
    // Get the title of Login Page
    public String getLoginTitle() {
        return titleText.getText();
    }
 
    public void login(String strUserName, String strPassword) {
 
        // Fill user name
        this.setUserName(strUserName);
 
        // Fill password
        this.setPassword(strPassword);
 
        // Click Login button
        this.clickLogin();
 
    }
}
