package login;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginNewWithData extends ParentTest {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.loginIntoApp(dataForValidLogin.get("login").toString(),dataForValidLogin.get("pass").toString());

        Assert.assertTrue("Avatar is present", homePage.isAvatarDisplayed());

    }

    @Test
    public void invalidLogin(){
        loginPage.loginIntoApp("someinvalidtetx","909090");
        Assert.assertFalse("Can't login with provided credentials", homePage.isAvatarDisplayed());
    }
}
