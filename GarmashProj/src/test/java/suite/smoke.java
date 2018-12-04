package suite;

import Login.LoginNew;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import providers.AddNewProvider;
import spares.AddNewSpare;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginNew.class,
                AddNewSpare.class,
                AddNewProvider.class
        }
)

public class smoke {
}
