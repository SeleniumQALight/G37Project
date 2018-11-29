package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InvalidLoginWithParams extends ParentTest {
    String login;
    String password;

    public InvalidLoginWithParams(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student","906090"},
                {"Login","909090"},
                {"Login","Pass"}
        });
    }

    @Test
    public void invalidLoginWithParams(){
     loginPage.loginIntoApp(login,password);
     checkExpectedResult("Avatar should not be present",homePage.isAvatarDisplayed(),false);
    }
}
