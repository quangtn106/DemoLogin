package test;

import driver.DriverFactory;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends BaseWeb {

    @Test
    public void loginTest() throws Exception {
        //Initialize PropertiesHelper
        PropertiesHelper prop = new PropertiesHelper();

        //Initialize Page Object
        HomePage home = new HomePage(DriverFactory.getInstance().getDriver());
        LoginPage login =  new LoginPage(DriverFactory.getInstance().getDriver());

        //Get credential from the properties file
        String telNum = prop.getPropertyValueByKey("username");
        String pw = prop.getPropertyValueByKey("password");

        //testcase
        home.clickLoginBtn();
        login.fillTel(telNum);
        login.fillPassword(pw);
        login.clickSubmit();
        home.isLoginSuccess();
    }
}
