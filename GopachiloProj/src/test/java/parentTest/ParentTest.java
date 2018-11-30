package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
     protected LoginPage loginPage;
     protected HomePage homePage;
     protected SparePage sparePage;
    protected EditSparePage editSparePage;


    @Before
    public void seatUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage=new LoginPage(webDriver);
        homePage=new HomePage(webDriver);
        sparePage=new SparePage(webDriver);
        editSparePage=new EditSparePage(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();

    }

    public void checkExpectedresult(String message,
                                    boolean actualResalt,boolean expectedResalt){
        Assert.assertEquals(message,expectedResalt,actualResalt);
    }
    public void checkExpectedresult(String message, boolean actualResalt){
        checkExpectedresult(message,actualResalt,true);
    }
}
