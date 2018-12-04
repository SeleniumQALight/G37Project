package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.Parent_Test;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class InvalidLoginWithParameters extends Parent_Test {

    String login;
    String password;

    public InvalidLoginWithParameters(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                {"Student", "906090" },
                {"Login", "909090"},
                {"Login", "Password"},
                {"",""},
                {"   "," "},
                {"909090", "student"}
        });
    }

    @Test
    public void invalidLoginWithParameters(){
        loginPage.loginInToApp(login, password);
        checkExpectedResult("Avatar isn't present", homePage.isAvatarDisplayed(), false);
    }


}

