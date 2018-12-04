package loginTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UnValidLoginWithParams extends ParentTest {
    String login;
    String pass;

    public UnValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData () {
        return Arrays.asList(new Object [] []{
                {"Studert", "906090"},
                {"GHjbhj", " "},
                {"%HHH", "9999999%"}
        });
    }


    @Test
    public void unValidLoginWithParameters () {
        loginPage.loginInToApp(login, pass);
        checkExpectedResult("Avatar should not be present"
                , homePage.isAvatarDislpayed()
                , false);
    }
}
