package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SparePage sparePage;


    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage  = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}