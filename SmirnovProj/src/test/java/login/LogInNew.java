package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LogInNew extends ParentTest {

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
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
