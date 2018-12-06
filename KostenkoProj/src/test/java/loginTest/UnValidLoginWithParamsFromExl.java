package loginTest;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UnValidLoginWithParamsFromExl extends ParentTest {
    String login;
    String pass;

    public UnValidLoginWithParamsFromExl(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
//    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
//    public static Collection testData () {
//        return Arrays.asList(new Object [] []{
//                {"Studert", "906090"},
//                {"GHjbhj", " "},
//                {"%HHH", "9999999%"}
//        });
//    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData () throws IOException {
        InputStream spreadsheet = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void unValidLoginWithParameters () {
        loginPage.loginInToApp(login, pass);
        checkExpectedResult("Avatar should not be present"
                , homePage.isAvatarDislpayed()
                , false);
    }
}
