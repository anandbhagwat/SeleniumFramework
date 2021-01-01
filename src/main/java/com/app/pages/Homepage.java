package com.app.pages;

import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage{
    WebDriver driver;
    public Homepage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }
}
