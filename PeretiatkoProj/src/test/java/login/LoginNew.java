package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonEnter();
        Assert.assertTrue("Avatar has not appeared", homePage.isAvatarPresent());
    }

    @Test
    public void inValidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("student");
        loginPage.enterPassword("906090");
        loginPage.clickButtonEnter();
        Assert.assertFalse("Avatar should be not present", homePage.isAvatarPresent());
    }
}