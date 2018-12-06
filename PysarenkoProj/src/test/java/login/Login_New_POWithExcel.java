package login;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.Parent_Test;

import java.io.IOException;
import java.util.Map;

public class Login_New_POWithExcel extends Parent_Test {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
//        loginPage.openLoginPage();
//        loginPage.enterLogin("Student");
//        loginPage.enterPassword("909090");
//        loginPage.clickButtonVhod();
        loginPage.loginInToApp(dataForValidLogin.get("login").toString(),dataForValidLogin.get("pass").toString());

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());

    }


    }


