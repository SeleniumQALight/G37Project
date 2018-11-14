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

public class Login {

    WebDriver webDriver;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validLogin(){

        webDriver.get("http://v3.test.itpmgroup.com");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");


        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar isn't present",
                isAvatarPresent());


    }

    private boolean isAvatarPresent(){
        try{
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }


    @Test
    public void invalidLoginName(){
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("NotAStudent");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click();
//        try{
//            Thread.sleep(3000);
//        }catch(Exception e){
//
//        }

        Assert.assertTrue("User logged in with wrong Login",
                isLoginLogoDisplayed());


    }

    private boolean isLoginLogoDisplayed(){
        try{
           return webDriver.findElement(By.xpath(".//div[@class = 'login-logo']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    @Test
    public void invalidPassword(){
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("Chupakabra");

        webDriver.findElement(By.tagName("button")).click();
//        try{
//            Thread.sleep(3000);
//        }catch(Exception e){
//
//        }


        Assert.assertTrue("User logged in with wrong Password",
                isLoginLogoDisplayed());


    }
}
