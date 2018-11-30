package logIn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLogInWithParameters extends ParentTest {
    String login;
    String password;

    public UnValidLogInWithParameters(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Login", "909090"},
                {"Login", "Pass"}
        });
    }

    @Test
    public void unValidLogInWithParameters(){
        loginPage.loginIntoApp(login, password);
        checkExpectedesult("Avatar should not be present", homePage.isAvatarDisplayed(), false);
    }
}
