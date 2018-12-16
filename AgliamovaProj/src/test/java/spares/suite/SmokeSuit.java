package spares.suite;


import login.LoginNew;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spares.AddNewSpares;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginNew.class,
                AddNewSpares.class
        }
)
public class SmokeSuit {

}
