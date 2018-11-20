package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.Parent_Test;

public class Login_New_PO extends Parent_Test {

    @Test
    public void validLogin(){
//        loginPage.openLoginPage();
//        loginPage.enterLogin("Student");
//        loginPage.enterPassword("909090");
//        loginPage.clickButtonVhod();
        loginPage.loginInToApp("Student","909090");

        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());

    }

    @Test
    public void invalidLogin(){
//        loginPage.openLoginPage();
//        loginPage.enterLogin("Student");
//        loginPage.enterPassword("808080");
//        loginPage.clickButtonVhod();
        loginPage.loginInToApp("Student", "808080");

        Assert.assertTrue("User logged in with wrong Password",
                loginPage.isLoginLogoDisplayed());
    }


}
