package parentTest;

import login.Login_New_PO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Parent_Test {

    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;
    protected ProvidersPage providersPage;
    protected EditProvidersPage editProvidersPage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
        providersPage = new ProvidersPage(webDriver);
        editProvidersPage = new EditProvidersPage(webDriver);



    }

        @After
        public void tearDown(){
            webDriver.quit();
        }

        public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult){
            Assert.assertEquals(message, expectedResult, actualResult);
        }

        public void checkExpectedResult(String message, boolean actualResult ){
        checkExpectedResult(message, actualResult, true);
        }



}