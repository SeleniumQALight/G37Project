package Login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

    public class UnvalidLoginWithParams extends ParentTest {
    String login;
    String pass;

    public UnvalidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                {"Student", "906090"},
                {"Login", "909090"},
                {"Login", "Pass"}
        });

    }


    @Test
    public void unValidLoginWithParams () {
        loginPage.loginInToApp(login, pass);
        checkExpectedResult("Avatar should be present", homePage.isAvatarDisplayed(), false);
    }
}
