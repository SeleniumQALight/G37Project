package parentTest;

import io.qameta.allure.Attachment;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    Logger logger = Logger.getLogger(getClass());

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;
    protected SparesEditPage sparesEditPage;
    protected ProvidersPage providersPage;
    protected ProviderEditPage providerEditPage;

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
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore");  // Suppress the "What's new" page
            webDriver = new FirefoxDriver();
        } else {
            Assert.fail("Wrong browser name");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver);
        sparesEditPage = new SparesEditPage(webDriver);
        providersPage = new ProvidersPage(webDriver);
        providerEditPage = new ProviderEditPage(webDriver);
    }

    @After
    public void tearDown() {
//        webDriver.quit();  //Закрывает браузер
    }

    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult){
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    public void checkExpectedResult(String message, boolean actualResult){
        checkExpectedResult(message, actualResult, true);
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }
        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }
        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }
        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };
}
