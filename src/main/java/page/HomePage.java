package page;

import helpers.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends CommonFunctions {

    WebDriver driver = null;

    //Element
    @FindBy(xpath = "//a[@href='https://accounts.chotot.com?continue=https%3A%2F%2Fwww.chotot.com%2F']")
    private WebElement loginBtn;

    //Element
    @FindBy(xpath = "//a[@href='https://www.chotot.com/user/9b3b90b69e8ce5dd45ded92248e73d06#xtatc=INT-1-[Profileview]']")
    private WebElement profile;

    //Initialize elements on the page
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Action click login button
    public void clickLoginBtn() {
        waitForElementDisplay(this.driver, loginBtn);
        loginBtn.click();
    }

    //Action verify login
    public void isLoginSuccess() {
        waitForElementDisplay(this.driver, profile);
        boolean status = profile.isDisplayed();
        if (status) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Can not login.");
        }
    }
}
