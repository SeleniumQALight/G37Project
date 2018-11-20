package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {

    @Test
    public void validLogin(){
        loginPage.openLoginPage("http://v3.test.itpmgroup.com/login");
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is present", homePage.isAvatarPresent());

    }

    @Test
    public void invalidLogin(){
        loginPage.openLoginPage("http://v3.test.itpmgroup.com/login");
        loginPage.loginIntoApp("someinvalidtetx","909090");
        Assert.assertFalse("Can't login with provided credentials", homePage.isAvatarPresent());
    }
}
