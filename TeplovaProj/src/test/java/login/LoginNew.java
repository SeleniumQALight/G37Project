package login;

import org.junit.Assert;
import org.junit.Test;
import parentTeest.ParentTest;

/**
 * Created by 123 on 13.11.2018.
 */
public class LoginNew extends ParentTest {


    @Test

    public void validLogin (){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonEnter();
        Assert.assertTrue("avatar isn't present", homePage.isAvatarPresent());

    }

    @Test
    public void invalidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonEnter();
        Assert.assertTrue("Login isn't correct", homePage.isAvatarPresent());
    }




}
