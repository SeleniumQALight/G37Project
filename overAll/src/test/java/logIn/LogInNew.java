package logIn;

import org.junit.Assert;
import org.junit.Test;
import parenTest.ParentTest;

public class LogInNew extends ParentTest{
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());

    }
}
