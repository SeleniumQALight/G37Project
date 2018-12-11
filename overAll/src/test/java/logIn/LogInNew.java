package logIn;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LogInNew extends ParentTest{
    @Test
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDislpayed());

    }

    @Test
    public void unValidLogin(){
        loginPage.loginInToApp("Student","909090");
        checkExpectedResult("Avatar should not be present"
                , homePage .isAvatarDislpayed()
                , false);

    }
}
