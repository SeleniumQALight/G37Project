package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InvalidLoginWithoutPageObject {
    WebDriver webDriver;

    @Before

    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After

    public void tearDown(){
        webDriver.quit();
    }

    @Test

    public void invalidLogin(){

        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("12345678");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("123456");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Password and login are not match",
                isLoginPresent());
        }

    public boolean isLoginPresent(){
        try{
            return webDriver.findElement(By.xpath(".//*[@href='http://v3.test.itpmgroup.com/']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
