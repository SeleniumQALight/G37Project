package suits;

import Login.LogInNew;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spares.AddNewSpare;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LogInNew.class,
                AddNewSpare.class
        }
)

public class SmokeSuit {
}