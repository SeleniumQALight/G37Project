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

public class Login {
    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void validLogin() {

        webDriver.get("http://v3.test.itpmgroup.com");

        login("student", "9090902");
        Assert.assertTrue("Avatar is not present", isAvatarPresent());

    }

    @Test
    public void invalidLogin() {

        webDriver.get("http://v3.test.itpmgroup.com");
        login("", "");
        login("wrr", "909090");
        login("student", "909045");
        Assert.assertEquals("Account of spare:Авторизация", webDriver.getTitle());
    }

    private void login(String log, String pas) {
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys(log);

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys(pas);

        webDriver.findElement(By.tagName("button")).click();

    }

    private boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
