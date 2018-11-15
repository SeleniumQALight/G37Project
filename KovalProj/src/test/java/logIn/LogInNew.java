package logIn;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LogInNew extends ParentTest {
    @Test
    public void validLogIn(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar isn't present", homePage.isAvatarPresent());
    }
}
