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

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
        // homework 17.11.2018
    @Test
    public void inValidLogin(){
        logInPage.openLogInPage();
        logInPage.enterLogin("Student");
        logInPage.enterPassword("909191");
        logInPage.clickButtonVhod();

        checkExpectedResult("Button'buttonVhodDisplayed' is not present. User was navigated to HomePage", logInPage.buttonVhodDisplayed());
    }

    // homework 17.11.2018
    @Test
    public void logIn() {
        logInPage.loginInToApp("Student", "906090");

        checkExpectedResult("User has passed authorization with incorrect password", logInPage.buttonVhodDisplayed());
    }
}
