package suit;


import login.LoginNew;
import login.LoginWithoutPageObject;
import login.UnValidLoginWithParametersFromExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginNew.class,
                LoginWithoutPageObject.class,
                UnValidLoginWithParametersFromExcel.class
        }
)

public class SmokeSuit {
}
