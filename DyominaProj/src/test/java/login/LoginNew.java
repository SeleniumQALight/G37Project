package login;

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

//        Assert.assertTrue("Avetar is not present", homePage.isAvatarDisplayed());
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
}
