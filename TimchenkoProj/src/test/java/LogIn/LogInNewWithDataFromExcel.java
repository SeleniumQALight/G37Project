package LogIn;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LogInNewWithDataFromExcel extends ParentTest {

    @Test

    public void validLogIn () throws IOException {
        logInPage.openLogInPage();
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        logInPage.openLogInPage();
        logInPage.enterLogin (dataForValidLogin.get ("login").toString());
        logInPage.enterPassWord (dataForValidLogin.get("pass").toString());
        logInPage.clickButtonEnter();
        //logInPage.clickStudentButton();
        //logInPage.exitButton();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());


    }
    }


