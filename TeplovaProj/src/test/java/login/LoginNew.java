package login;

import org.junit.Test;
import parentTeest.ParentTest;

/**
 * Created by 123 on 13.11.2018.
 */
public class LoginNew extends ParentTest {


    @Test

    public void validLogin (){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonEnter();
    }



}
