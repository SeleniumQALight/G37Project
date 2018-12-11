package LogIn;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LogInNew extends ParentTest {

    @Test

    public void validLogIn (){
        logInPage.openLogInPage();
        logInPage.enterLogin ("Student");
        logInPage.enterPassWord ("909090");
        logInPage.clickButtonEnter();
        //logInPage.clickStudentButton();
        //logInPage.exitButton();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());


    }
    @Test
    @Ignore
    public  void inValidLogIn () {
        logInPage.loginInToApp("Student","906090");
        Assert.assertTrue("Attention! User enters with invalid inputs", logInPage.isButtonEnterDisplayed());
    }

    }


