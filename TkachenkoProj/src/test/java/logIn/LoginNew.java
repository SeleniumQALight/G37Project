package logIn;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void invalidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student1");
        loginPage.enterPassword("9090909");
        loginPage.clickButtonVhod();

        Assert.assertTrue("User logged in with invalid credentials",loginPage.isLogoPresent());
    }
    @Test
    public void studentValidLogInHW(){
        loginPage.loginInToApp("Student", "909090");
        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void studentInvalidLogInHW(){
        loginPage.loginInToApp("Student1", "9090909");
        Assert.assertTrue("User logged in with invalid credentials", loginPage.isLogoPresent());
    }
}
