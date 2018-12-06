package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)

public class UnValidLoginWithParameters extends ParentTest {
    String login = "98999";
    String pass = "90";

    public UnValidLoginWithParameters(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name="Parameters are {0} and {1})")

    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"98999", "90"},
                {"Login", "909090"},
//                {"Login", "90"},
//                {"98999", "Pass"},
                {"Login", "90"},

        }); }

        @Test
        public void unValidloginWithParameters () {
            loginPage.loginIntoApp(login, pass);
            checkExpectedResult("Avatar is not present"
                    , homePage.isAvatarPresent()
                    , false);
        }

         }
