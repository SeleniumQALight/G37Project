package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTeest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by 123 on 29.11.2018.
 */

@RunWith(Parameterized.class)

public class UnValidLoginWithParam extends ParentTest {

 String login  = "refaerfa54845";
 String pass  = "fgsg";

    public UnValidLoginWithParam(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Param are {0} and {1}")
    public static Collection TestData(){

        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Login", "909090"},
                {"Login", "909090"},
                {"Login","Pass"}

        });
    }


    @Test

    public void unValidLoginWithParameers(){

        loginPage.openLoginPage();
        loginPage.enterLogin("kghgsf");
        loginPage.enterPassword("erer");
        loginPage.clickButtonEnter();
        checkExpactedResult("Avatar must be present", homePage.isAvatarPresent(),
                false);
    }
}
