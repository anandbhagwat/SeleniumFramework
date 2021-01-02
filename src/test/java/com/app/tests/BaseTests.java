package com.app.tests;

import com.app.pages.LoginPage;
import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtilities;
import commonLibs.utils.ReportUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseTests {
    CommonDriver commonDriver;
    LoginPage loginPage;
    WebDriver driver;
    String url;

    Properties properties;
    String currentWorkingDirectory;
    String configFilename;
    String browserType;

    ReportUtilities reportUtilities;
    String reportFilename;

    @BeforeSuite
    public void preSetup() throws  Exception{
        currentWorkingDirectory = System.getProperty("user.dir");
        configFilename = currentWorkingDirectory + "/configs/config.properties";
        properties = ConfigUtilities.readProperties(configFilename);

        reportFilename = currentWorkingDirectory + "/reports/guru99TestReport.html";
        reportUtilities = new ReportUtilities(reportFilename);
    }
    @BeforeClass
    public void setUp() throws Exception{
        url = properties.getProperty("appURL");
        browserType = properties.getProperty("browser");
        commonDriver = new CommonDriver(browserType);
        driver = commonDriver.getDriver();
        loginPage = new LoginPage(driver);
        commonDriver.navigateToUrl(url);

    }

    @AfterClass
    public void tearDown(){
        commonDriver.closeAllBrowser();
    }

    @AfterSuite
    public void postTearDown(){
        reportUtilities.flushReport();
    }
}
