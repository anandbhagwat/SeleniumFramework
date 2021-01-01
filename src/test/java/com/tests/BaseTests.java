package com.tests;

import com.app.pages.LoginPage;
import commonLibs.implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    CommonDriver commonDriver;
    LoginPage loginPage;
    WebDriver driver;
    String url;
    @BeforeClass
    public void setUp() throws Exception{
        url = "http://demo.guru99.com/V4/";
        commonDriver = new CommonDriver("chrome");
        driver = commonDriver.getDriver();
        loginPage = new LoginPage(driver);
        commonDriver.navigateToUrl(url);

    }

    @AfterClass
    public void tearDown(){
        commonDriver.closeAllBrowser();
    }
}
