package login;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LogInNew extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openLogInPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());


    }
}
