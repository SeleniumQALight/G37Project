package login;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LogInNewWithDataFromExcel extends ParentTest {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openLoginPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPassword(dataForValidLogin.get("pass").toString());
        loginPage.clickButtonVhod();
        homePage.chekVisibleisAvatarPresent();

//        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
    }

    @Test
    public void invalidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("333333");
        loginPage.clickButtonVhod();
        loginPage.chekVisibleLoginPage();

    }

}
