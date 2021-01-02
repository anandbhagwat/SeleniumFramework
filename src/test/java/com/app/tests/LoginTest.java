package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTests{

    @Test
    @Parameters({"username", "password"})
    public void verifyUserLoginWithCorrectCredentials(String username, String password){
            loginPage.loginToApplication(username, password);

            String expectTitle= "Guru99 Bank Manager HomePage";
            String actualTitle;
            actualTitle = commonDriver.getTitleOfThePage();
            Assert.assertEquals(actualTitle, expectTitle);

    }
}
