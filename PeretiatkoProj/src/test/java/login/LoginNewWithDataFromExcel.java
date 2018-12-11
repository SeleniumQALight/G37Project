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
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin   = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.loginInToApp(dataForValidLogin.get("login").toString(), dataForValidLogin.get("pass").toString());
        Assert.assertTrue("Avatar has not appeared", homePage.isAvatarPresent());
    }
}