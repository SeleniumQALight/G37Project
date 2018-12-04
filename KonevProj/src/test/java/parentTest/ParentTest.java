package parentTest;

import Pages.*;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    String browser = System.getProperty("browser");

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;
    protected ProviderPage providerPage;
    protected EditProviderPage editProviderPage;


    @Before
    public void setUp() {
        if ("chrome".equals(browser) || browser == null) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if (("firefox").equals(browser)) {
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page

            webDriver = new FirefoxDriver();
        } else {
            Assert.fail("Wrong browser name");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //Ждем каждый элемент максимум 3 секунды
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
        providerPage = new ProviderPage(webDriver);
        editProviderPage = new EditProviderPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    public void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

}
