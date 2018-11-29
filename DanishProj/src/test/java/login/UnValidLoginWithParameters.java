package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParameters extends ParentTest {
    String login ;
    String password ;

    public UnValidLoginWithParameters(String login, String password) {
        this.login = login;
        this.password = password;
    }
    @Parameterized.Parameters (name =  "parameters are {0} aand {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student","906090"},
                {"Login","909090" },
                {"Login", "Password"}
        });
    }

    @Test
    public void unValidLoginWithParameters(){
        loginPage.loginInToApp(login, password);
        checkExpectedResult("Avatar should not be present",homePage.isAvatarDisplayed(),false );
    }
}
