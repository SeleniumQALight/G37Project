package login;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Test
    public void validLogin(){
        logInPage.openLogInPage();
        logInPage.enterLogin("Student");
        logInPage.enterPassword("909090");
        logInPage.clickButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());



    }

}
