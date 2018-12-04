package logIn;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LogInNewWithDataFromExcel extends ParentTest {
    @Test
    public void validLogIn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogIn = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openLoginPage();
        loginPage.enterLogin(dataForValidLogIn.get("login").toString());
        loginPage.enterPass(dataForValidLogIn.get("pass").toString());
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar isn't present", homePage.isAvatarDisplayed());
    }
}
