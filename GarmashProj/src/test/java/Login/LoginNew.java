package Login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginNew extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.loginInToApp("Student", "909090");
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void inValidLogin() {
        loginPage.loginInToApp("Student", "906090");
        checkExpectedResult("It is not a login page", loginPage.isInputLoginDisplayed());
    }
}
