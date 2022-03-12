package com.cucumber.pageobjectmodel.definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {
	
	String driverPath = "D:\\\\SeleniumJars\\\\geckodriver.exe";
	 
    WebDriver driver;
 
    Login objLogin;
 
    HomePage objHomePage;
 
    @Before
    public void setup() {
 
        // Initialize the webdriver and open the browser
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    /**
     * 
     * This test go to https://opensource-demo.orangehrmlive.com/ Verify login page title as LOGIN Panel Login to application Verify the home page using welcome
     * message
     * 
     */
 
    @Given("User is on HRMLogin page")
    public void loginTest() {
 
        // Create Login Page object
        objLogin = new Login(driver);
 
        // Verify login page text
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("LOGIN Panel"));
 
    }
 
    @When("User enters username as {string} and password as {string}")
    public void HomeTest(String userName, String passWord) {
 
        // login to application
        objLogin.login(userName, passWord);
 
        // go the next page
        objHomePage = new HomePage(driver);
    }
 
    @Then("User should be able to login and new page open")
    public void verify() {
 
        // Verify home page
        Assert.assertTrue(objHomePage.getHomePageText().contains("Welcome"));
 
    }
 
    @After
    public void close() {
 
        // Close the browser
        driver.close();
    }

}
