package LogIn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


@RunWith(Parameterized.class)

public class UnValidLogInWithParam extends ParentTest {
    String logIn ;
    String pass;

    public UnValidLogInWithParam(String logIn, String pass) {
        this.logIn = logIn;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")

    public  static Collection testData () {
        return Arrays.asList(new Object [][]{

                {"Student", "9077"},
                {"LogIn", "909090"},
                {"Login", "Pass"}
        });
    }
    @Test

    public void unValidLogInWithParam () {
        logInPage.loginInToApp(logIn, pass);
        expectedResult ("Avatar should not be present",homePage.isAvatarDisplayed(),false);
    }
}
