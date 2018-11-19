package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Test
    public void validLogin(){
        logInPage.openLogInPage();
        logInPage.enterLogin("Student");
        logInPage.enterPassword("909090");
        logInPage.clickButtonVhod();  // homework

        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
    }
        // homework 17.11.2018
    @Test
    public void inValidLogin(){
        logInPage.openLogInPage();
        logInPage.enterLogin("Student");
        logInPage.enterPassword("909191");
        logInPage.clickButtonVhod();

        Assert.assertTrue("Button'Vhod' is not present. User was navigated to HomePage", logInPage.isButtonPresent());
    }

    // homework 17.11.2018
    @Test
    public void logIn() {
        logInPage.loginInToApp("Student", "906090");

        Assert.assertTrue("User has passed authorization with incorrect password", logInPage.isButtonPresent());
    }
}
