package page;

import helpers.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends CommonFunctions {

    WebDriver driver = null;

    //Element
    @FindBy(xpath = "//input[@type='tel']")
    private WebElement tel;

    //Element
    @FindBy(xpath = "//input[@type='password']")
    private WebElement pass;

    //Element
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    //Initialize elements on the page
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,  this);
        this.driver = driver;
    }

    //Action fill telephone number
    public void fillTel(String tel) {
        waitForElementDisplay(this.driver, this.tel);
        this.tel.clear();
        this.tel.sendKeys(tel);
    }

    //Action fill password
    public void fillPassword(String pass) {
        waitForElementDisplay(this.driver, this.pass);
        this.pass.clear();
        this.pass.sendKeys(pass);
    }

    //Action click submit button
    public void clickSubmit() {
        waitForElementDisplay(this.driver, this.submit);
        this.submit.isEnabled();
        this.submit.click();
    }
}
