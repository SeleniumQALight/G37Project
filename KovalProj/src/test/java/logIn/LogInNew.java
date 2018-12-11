package logIn;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LogInNew extends ParentTest {
    @Test
    public void validLogIn(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickButtonVhod();

        checkExpectedResult("Avatar isn't present", homePage.isAvatarDisplayed());
    }

    @Test
    //Ignore
    public void inValidLogIn() {
        loginPage.openLoginPage();
        loginPage.enterLogin("Studen");
        loginPage.enterPass("909090");
        loginPage.clickButtonVhod();

        checkExpectedResult("Login page isn't displayed", loginPage.isAutorizationSectionDisplayed());
    }


}
