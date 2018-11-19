package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();
        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());

    }

        @Test
        public void inValidLogin() {
            loginPage.openLoginPage();
            loginPage.enterLogin("student");
            loginPage.enterPassword("909090");
            loginPage.clickButtonVhod();
            Assert.assertFalse("Avatar should not be present!", homePage.isAvatarPresent());

        }
}
