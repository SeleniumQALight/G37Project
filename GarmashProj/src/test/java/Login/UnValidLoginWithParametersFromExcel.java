package Login;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParametersFromExcel extends ParentTest {
    private String login;
    private String password;


    public UnValidLoginWithParametersFromExcel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    //    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
//    public static Collection testData() {
//        return Arrays.asList(new Object[][]{
//                        {"Student", "906090"},
//                        {"Login", "909090"},
//                        {"Login", "Pass"}
//                }
//        );
//    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void unValidLoginWithParameters() {
        loginPage.loginInToApp(login, password);
        checkExpectedResult("Avatar should not be present", homePage.isAvatarDisplayed(), false);
    }
}
