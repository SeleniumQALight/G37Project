package login;

import libs.UtilsForDB;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LoginNew extends ParentTest {
    @Test
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        UtilsForDB utilsForDB = new UtilsForDB();
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword(utilsForDB.getPassForLogin("Student"));
        loginPage.clickButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void notValidLogin(){
        loginPage.loginInToApp("Student", "906090");

     checkExpectedResult("Avatar is not present" , loginPage.actionsWithOurElements.isAuthorizationFormPresent());
    }

}
