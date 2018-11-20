package logIn;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest{
        @Test
        public void validLogin(){
            loginPage.openLoginPage();
            loginPage.enterLogin("Student");
            loginPage.enterPassword("909090");
            loginPage.clickButtonVhod();

            Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
        }
        @Test
        public void invalidLogin (){
            loginPage.openLoginPage();
            loginPage.enterLogin("Студент");
            loginPage.enterPassword("909090");
            loginPage.clickButtonVhod();

            Assert.assertTrue("Error, you was loged in", loginPage.isLoginInputPresent());
        }
        @Test
    public void loginWithGivenCreds(){
            loginPage.loginInToApp("student", "909090");
            Assert.assertTrue("Not logged in", homePage.isAvatarPresent());
        }
    }

