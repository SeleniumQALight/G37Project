package suits;

import login.Login_New_PO;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spares.AddNewSpare;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                Login_New_PO.class,
                AddNewSpare.class

        }
)
public class SmokeSuit {

}
