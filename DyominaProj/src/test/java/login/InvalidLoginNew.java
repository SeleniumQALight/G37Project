package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class InvalidLoginNew extends ParentTest {

   @Test
    public void InvalidLogin(){
        loginPage.loginInToApp("Student", "906090");

       Assert.assertTrue("Login form can not be found", loginPage.isLogoFormDisplayed());
    }
}
