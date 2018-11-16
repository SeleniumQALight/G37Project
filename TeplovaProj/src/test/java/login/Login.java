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

/**
 * Created by 123 on 08.11.2018.
 */
public class Login {
    WebDriver webDriver;

    @Before
    public void setup() {
        File file = new File("./src/Dviver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void validLogIn() {


        webDriver.get("http://v3.test.itpmgroup.com/");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.name("_password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button")).click();

        Assert.assertTrue("Avatar is not present",
                webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());

        webDriver.quit();


    }

    @Test
    public void invalidLogIn() {

        webDriver.get("http://v3.test.itpmgroup.com/");

        webDriver.findElement(By.name("_username"));
        webDriver.findElement(By.name("_username")).sendKeys("Student1");

        webDriver.findElement(By.name("_password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button")).click();

//        webDriver.findElement(By.xpath(".//*/b[text()='Учет запчастей']" ));

        Assert.assertTrue("Invalid Password or Username",
                webDriver.findElement(By.xpath(".//*/b[text()='Учет запчастей']")).isDisplayed());

        webDriver.quit();


    }

    //   private  boolean  isAvatarPresent(){
//        try {
//            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
//        }
//        catch (Exception e){
//            return false;
//        }
//   }
    @After

    public void teardown() {
        webDriver.quit();
    }


}
