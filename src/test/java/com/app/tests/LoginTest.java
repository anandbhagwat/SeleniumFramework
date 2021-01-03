package com.app.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTests{

    @Test
    @Parameters({"username", "password"})
    public void verifyUserLoginWithCorrectCredentials(String username, String password){
            loginPage.loginToApplication(username, password);
            reportUtilities.createATestCase("Verify User Login With Correct Credentials");
            reportUtilities.addTestlogs(Status.INFO,"Performing Login");
            String expectTitle= "OrangeHRM";
            String actualTitle;
            actualTitle = commonDriver.getTitleOfThePage();
            reportUtilities.addTestlogs(Status.INFO,"Asserting Page Title After Login");
            Assert.assertEquals(actualTitle, expectTitle);


    }
}
