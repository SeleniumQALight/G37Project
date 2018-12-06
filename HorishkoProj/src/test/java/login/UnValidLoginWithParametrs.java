package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UnValidLoginWithParametrs extends ParentTest {
    String login;
    String pass;

    public UnValidLoginWithParametrs(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{  // набор неправильных данных для невалидной авторизации
                {"Student","906090"},
                {"Login", "909090"},
                {"Login", "pass"}
        });
    }

    @Test
    public void unValidLoginWithParametrs (){

        loginPage.loginInToApp(login, pass);
        checkExpectedResult("Avatar should not be present", homePage.isAvatarDisplayed(), false);
    }
}
