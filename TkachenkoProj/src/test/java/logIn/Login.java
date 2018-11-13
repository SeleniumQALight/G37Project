package logIn;

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
    WebDriver driver;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void validLogIn(){

        driver.get("http://v3.test.itpmgroup.com");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("909090");

        driver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not present on the main page", isAvatarPresent());
    }
    @Test
    public void invalidLogin(){
        driver.get("http://v3.test.itpmgroup.com");

        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student1");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("909090");

        driver.findElement(By.tagName("button")).click();

        Assert.assertTrue("User logged in with invalid credentials",isLogoPresent());
    }
    private boolean isAvatarPresent(){
        try {
            return driver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();

        }catch (Exception e){
            return false;
        }
    }
    private boolean isLogoPresent(){
        try {
            return driver.findElement(By.xpath(".//*[@class='login-logo']")).isDisplayed();

        }catch (Exception e){
            return false;
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
