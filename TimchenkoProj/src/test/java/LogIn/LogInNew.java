package LogIn;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LogInNew extends ParentTest {

    @Test

    public void validLogIn (){
        logInPage.openLogInPage();
        logInPage.enterLogin ("Student");
        logInPage.enterPassWord ("909090");
        logInPage.clickuttonEnter ();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresented());




    }


}
