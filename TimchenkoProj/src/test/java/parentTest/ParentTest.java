package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
  protected  LogInPage logInPage;
  protected HomePage homePage;
  protected SparePage sparePage;
  protected EditSparePage editSparePage;
  protected PartiesPage partiesPage;
  protected  EditPartiesPage editPartiesPage;


    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
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
