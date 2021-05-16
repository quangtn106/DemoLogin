package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

    //Wait for element is displayed
    protected void waitForElementDisplay(WebDriver driver, WebElement el) {
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(el));
    }
}
