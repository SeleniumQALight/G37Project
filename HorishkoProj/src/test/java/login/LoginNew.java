package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.loginInToApp("Student", "909090");
        Assert.assertTrue("Avatar is not present" ,
                homePage.isAvatarPresent());
    }
    @Test
    public void unvalidLogin(){
        loginPage.loginInToApp("Teacher", "906090");
        Assert.assertFalse("Avatar is not present" ,
                homePage.isAvatarPresent());
    }
//    public void validLogin(){
//        loginPage.openLoginPage();
//        loginPage.enterLogin("Student");
//        loginPage.enterPassword("909090");
//        loginPage.clickButtonVhod();
//
//        Assert.assertTrue("Avatar is not present" ,
//                homePage.isAvatarPresent());
//    }
//    @Test
//    public void unvalidLogin(){
//        loginPage.openLoginPage();
//        loginPage.enterLogin("Teacher");
//        loginPage.enterPassword("909090");
//        loginPage.clickButtonVhod();
//
//        Assert.assertFalse("Avatar is not present" ,
//                homePage.isAvatarPresent());
//    }
}
