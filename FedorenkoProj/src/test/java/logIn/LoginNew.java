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
        public  void invalidLogin(){
            loginPage.openLoginPage();
            loginPage.enterLogin("student");
            loginPage.enterPassword("906090");
            loginPage.clickButtonVhod();

            Assert.assertTrue("incorrect Login input validation", loginPage.isLoginFormPresent());
        }
        @Test
        public void loginWithGivenCreds (){
            loginPage.loginInToApp("student", "906090");

            Assert.assertTrue("Invalid Credentials entered", homePage.isAvatarPresent());
        }
    }

