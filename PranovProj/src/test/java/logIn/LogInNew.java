package logIn;

import io.qameta.allure.Step;
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


        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

//    @Test
//
//    public void unValidLogin(){
//        loginPage.loginInToApp("Student", "909090");
//    }
}
