package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LogInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LogInPage logInPage;
    protected HomePage homePage;
    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown() {
        this.webDriver.quit();
    }

}
