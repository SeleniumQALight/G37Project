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
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    String browser = System.getProperty("browser");
    protected  static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
  protected  LogInPage logInPage;
  protected HomePage homePage;
  protected SparePage sparePage;
  protected EditSparePage editSparePage;
  protected PartiesPage partiesPage;
  protected  EditPartiesPage editPartiesPage;

  @Before
    public void setUp() {
        if ("chrome".equals(browser) || browser == null) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser)){
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page",0); // у фокса часто появляется рекламное окно
            String browser = System.getProperty("browser");
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver();
        } else  {
            Assert.fail("Wrong browser name");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logInPage =  new LogInPage( webDriver);
        homePage = new HomePage( webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
        partiesPage = new PartiesPage(webDriver);
        editPartiesPage = new EditPartiesPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public  void  expectedResult (String message, boolean actualResult, boolean expectedResult) {

        Assert.assertEquals(message, expectedResult, actualResult);
    }

    public  void expectedResult (String message, boolean actualResult) {
        expectedResult(message, actualResult, true);
    }
}
