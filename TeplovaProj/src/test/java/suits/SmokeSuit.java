package suits;

import login.LoginNew;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spares.AddNewSpare;

/**
 * Created by 123 on 29.11.2018.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginNew.class,
                AddNewSpare.class
        }
)
public class SmokeSuit {
}
