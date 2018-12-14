package logIn;

import io.qameta.allure.Step;
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


        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void invalidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student1");
        loginPage.enterPassword("9090909");
        loginPage.clickButtonVhod();


        checkExpectedResult("User logged in with invalid credentials",loginPage.isLogoPresent());
    }
    @Test
    public void studentValidLogInHW(){
        loginPage.loginInToApp("Student", "909090");
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void studentInvalidLogInHW(){
        loginPage.loginInToApp("Student1", "9090909");
        checkExpectedResult("User logged in with invalid credentials", loginPage.isLogoPresent());
    }
}
