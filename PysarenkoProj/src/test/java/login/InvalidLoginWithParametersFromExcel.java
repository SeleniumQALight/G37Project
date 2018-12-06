package login;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.Parent_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class InvalidLoginWithParametersFromExcel extends Parent_Test {

    String login;
    String password;

    public InvalidLoginWithParametersFromExcel(String login, String password) {
        this.login = login;
        this.password = password;
    }

//    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
//    public static Collection testData(){
//        return Arrays.asList(new Object[][] {
//                {"Student", "906090" },
//                {"Login", "909090"},
//                {"Login", "Password"},
//                {"",""},
//                {"   "," "},
//                {"909090", "student"}
//        });
//    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException{
        InputStream spreadsheet = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet,"InvalidLogOn").getData();
    }


    @Test
    public void invalidLoginWithParameters(){
        loginPage.loginInToApp(login, password);
        checkExpectedResult("Avatar isn't present", homePage.isAvatarDisplayed(), false);
    }


}

