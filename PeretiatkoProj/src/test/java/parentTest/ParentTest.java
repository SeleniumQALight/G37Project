package parentTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String browser = System.getProperty("browser");
    WebDriver webDriver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;


    @Before
    public void setUp() {
        if ("chrome".equals(browser) || browser == null){
            File file = new File("./src/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            File file = new File("./src/drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver();
        } else {
            Assert.fail("Wrong browser name");
        }
        webDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage  = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);

    }

    public void checkExpectedResult(String message, boolean actualResult) {
        checkExpectedResult(message, actualResult, true);
    }
}