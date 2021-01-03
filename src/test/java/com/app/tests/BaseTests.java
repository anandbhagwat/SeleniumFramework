package com.app.tests;

import com.app.pages.LoginPage;
import com.aventstack.extentreports.Status;
import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtilities;
import commonLibs.utils.ReportUtilities;
import commonLibs.utils.ScreenShotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

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

    ScreenShotUtils screenShotUtils;

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

        screenShotUtils = new ScreenShotUtils(driver);
        commonDriver.navigateToUrl(url);
    }

    @AfterMethod
    public void postTestAction(ITestResult iTestResult) throws Exception{
        String testCaseName = iTestResult.getTestName();
        long executionTime = System.currentTimeMillis();
        String screenShotFileName = currentWorkingDirectory + "/screenshots/"+testCaseName+executionTime+".jpeg";
        if (iTestResult.getStatus()== iTestResult.FAILURE){
            reportUtilities.addTestlogs(Status.FAIL,"One or More Tests failed");
            screenShotUtils.captureAndSaveScreenShot(screenShotFileName);
            reportUtilities.attachScreenshotToReport(screenShotFileName);
        }
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
