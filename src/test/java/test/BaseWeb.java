package test;

import driver.BrowserFactory;
import driver.DriverFactory;
import helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseWeb {

    //Initialize helpers
    BrowserFactory bf = new BrowserFactory();
    PropertiesHelper prop = new PropertiesHelper();

    //Open browser and navigate to the page
    @BeforeMethod
    public void openBrowser() throws Exception {
        String url = prop.getPropertyValueByKey("url");
        String browser = prop.getPropertyValueByKey("browser");
        DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    //Close the browser after test
    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().quit();
    }
}
