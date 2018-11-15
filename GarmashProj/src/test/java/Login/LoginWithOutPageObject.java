package Login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginWithOutPageObject {
    WebDriver webDriver;


    private void login() {
        login("student", "909090");
    }

    private void login(String log, String pass) {
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys(log);
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys(pass);
        webDriver.findElement(By.tagName("button")).click();
    }

    private boolean isPresent(String xpath) {
        return isPresent(By.xpath(xpath));
    }

    private boolean isPresent(org.openqa.selenium.By by) {
        try {
            return webDriver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void invalidLogin() {
        login("stu", "909090");
        Assert.assertTrue("It is not a login page", isPresent(By.name("_username")));
    }

    @Test
    public void validLogin() {
        login();
        Assert.assertTrue("Avata" +
                "r is not present", isPresent(".//*[@class='pull-left info']"));
    }

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}