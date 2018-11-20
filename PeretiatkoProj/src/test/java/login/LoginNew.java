package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.loginInToApp("Student", "909090");
        Assert.assertTrue("Avatar has not appeared", homePage.isAvatarPresent());
    }

    @Test
    public void inValidLogin(){
        loginPage.loginInToApp("student", "906090");
        Assert.assertFalse("Avatar should be not present", homePage.isAvatarPresent());
    }
}