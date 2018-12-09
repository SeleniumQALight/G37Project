package LogIn;

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

public class UnValidLogInWithParamFromExcel extends ParentTest {
    String logIn ;
    String pass;

    public UnValidLogInWithParamFromExcel(String logIn, String pass) {
        this.logIn = logIn;
        this.pass = pass;
    }

//    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
//
//    public  static Collection testData () {
//        return Arrays.asList(new Object [][]{
//
//                {"Student", "9077"},
//                {"LogIn", "909090"},
//                {"Login", "Pass"}
//        });
//    }
  @Parameterized.Parameters (name = "Parameters are {0} and {1}")
  public  static  Collection testData() throws IOException {
      InputStream spreadSheet =  new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
      return new SpreadsheetData(spreadSheet, "InvalidLogOn").getData();
  }
    @Test

    public void unValidLogInWithParam () {
        logInPage.loginInToApp(logIn, pass);
        expectedResult ("Avatar should not be present",homePage.isAvatarDisplayed(),false);
    }
}
