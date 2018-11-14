package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.Parent_Test;

public class Login_New_PO extends Parent_Test {
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());

    }


}
