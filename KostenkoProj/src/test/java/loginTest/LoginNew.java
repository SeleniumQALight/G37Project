package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Test //анотация junit
    public void validLogin () {
        loginPage.openLoginPage();
        loginPage.enterLogin ("Student");
        loginPage.enterPassword ("909090");
        loginPage.clickButtonVhod ();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDislpayed());
    }

    @Test
    public void inValidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909191");
        loginPage.clickButtonVhod();

        checkExpectedResult("Button'buttonVhodDisplayed' is not present. User was navigated to HomePage", loginPage.isButtonVhodDisplayed());
    }

    // homework 17.11.2018
    @Test
    public void logIn() {
        loginPage.loginInToApp("Student", "906090");

        Assert.assertTrue("User has passed authorization with incorrect password", loginPage.isButtonVhodDisplayed());
    }
}


