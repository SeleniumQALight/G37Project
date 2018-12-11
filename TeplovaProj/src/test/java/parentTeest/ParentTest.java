package parentTeest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by 123 on 13.11.2018.
 */
public class ParentTest {

    WebDriver webDriver;
     protected LoginPage loginPage;
//     protected ParentPage parentPage;
     protected HomePage homePage;
     protected SparePage sparePage;
     protected EditSparePage editSparePage;

    @Before
    public void setUp(){
        File file = new File("src/Dviver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage= new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    public void checkExpactedResult(String message, boolean expectedlResult, boolean actualResult){
        Assert.assertEquals(message, expectedlResult, actualResult);
    }

    public void checkExpactedResult(String message, boolean actualResult){
        checkExpactedResult(message,actualResult, true);
    }

}
