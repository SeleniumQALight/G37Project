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
        UtilsForDB utilsForDB=new UtilsForDB();
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword(utilsForDB.getPassForLogin("Student"));
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDislpayed());

    }
}
