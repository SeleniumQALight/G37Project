package login;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTeest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 123 on 13.11.2018.
 */
public class LoginNew extends ParentTest {


    @Test

    public void validLogin () throws SQLException, IOException, ClassNotFoundException {
        UtilsForDB utilsForDB = new UtilsForDB();
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
//        loginPage.enterPassword(utilsForDB.getPassForLogin("909090"));
        loginPage.clickButtonEnter();
        Assert.assertTrue("avatar isn't present", homePage.isAvatarPresent());

    }

    @Test
    public void invalidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonEnter();
        Assert.assertTrue("Login isn't correct", homePage.isAvatarPresent());
    }




}
