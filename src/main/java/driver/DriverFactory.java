package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {}

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Get state of the driver
    public WebDriver getDriver() {
        return driver.get();
    }

    //Set state of the driver
    public void setDriver(WebDriver driverParam) {
        driver.set(driverParam);
    }

    //Close the driver
    public void quit() {
        driver.get().quit();
        driver.remove();
    }
}
