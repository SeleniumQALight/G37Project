package parentTeest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by 123 on 13.11.2018.
 */
public class ParentTest {

    WebDriver webDriver;
     protected LoginPage loginPage;
     protected HomePage homePage;
     protected SparePage sparePage;

    @Before
    public void setUp(){
        File file = new File("src/Dviver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage= new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);


    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}
