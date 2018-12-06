package login;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginNewWithDataFromExcel extends ParentTest {
    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();   //створили обєкт
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");

        logInPage.openLogInPage();
        logInPage.enterLogin(dataForValidLogin.get("login").toString());
        logInPage.enterPassword(dataForValidLogin.get("pass").toString());
        logInPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());
    }
}
