package parentTest;

import Pages.EditSparePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SparePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //Ждем каждый элемент максимум 3 секунды
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
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
        Assert.assertEquals(message, actualResult, true);
    }

}
