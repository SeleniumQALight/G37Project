package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {

    @Test
    public void validLogin(){
        loginPage.loginIntoApp("Student","909090");

        Assert.assertTrue("Avatar is present", homePage.isAvatarDisplayed());

    }

    @Test
    public void invalidLogin(){
        loginPage.loginIntoApp("someinvalidtetx","909090");
        Assert.assertFalse("Can't login with provided credentials", homePage.isAvatarDisplayed());
    }
}
