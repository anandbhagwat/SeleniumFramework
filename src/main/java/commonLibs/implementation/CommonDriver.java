package commonLibs.implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class CommonDriver {

    private WebDriver driver;

    private int pageLoadTimeOut;

    private int elementDetectionTimeout; //Implicit Wait


    public CommonDriver(String browserType) throws Exception {
        //Logic for Invoking the Browser
        pageLoadTimeOut =10;
        elementDetectionTimeout =10;

        if(browserType.equalsIgnoreCase("chrome"))
        {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browserType.equalsIgnoreCase("safari")){
            //ToDo Safari Executable to be added and pointed
        } else {
            throw  new Exception("Incorrect BrowserType Provided");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    public void navigateToUrl(String url){
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setPageLoadTimeOut(int pageLoadTimeOut) {
        this.pageLoadTimeOut = pageLoadTimeOut;
    }


    public void setElementDetectionTimeout(int elementDetectionTimeout) {
        this.elementDetectionTimeout = elementDetectionTimeout;
    }
}
