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
    WebDriver webDriver;  // create variable
    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe"); //
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();  // ініціалізуємо, вказуємо браузер
        webDriver.manage().window().maximize();   // встановили на весь екран
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //вказуємо драйверу протягом якого періоду виконувати дію
    }

    @Test // annotation вона вказує, що методи мають виконуватися
    public void validLogin() {
        webDriver.get("http://v3.test.itpmgroup.com"); // вказуємо URL

        webDriver.findElement(By.name("_username")).clear(); // знаходимо поле Login, clearing
        webDriver.findElement(By.name("_username")).sendKeys("Student"); // відправляємо по букві наш логін

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click();  // find button and click on it (дія мишки)

        Assert.assertTrue("Avatar is not present", isAvatarPresent()); //додали перевірку
    }

    private boolean isAvatarPresent(){
        try{
             return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();

        }catch (Exception e){
            return false;
        }

    }
     // homework
    @Test
    public void inValidLogin() {
        webDriver.get("http://v3.test.itpmgroup.com");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.name("_password")).clear();
        webDriver.findElement(By.name("_password")).sendKeys("909091");

        webDriver.findElement(By.tagName("button")).click();


        Assert.assertTrue("The Homepage is opened", isButtonPresent());
    }

    private boolean isButtonPresent(){
        try{
             return webDriver.findElement(By.tagName("button")).isDisplayed();

        }catch(Exception e){
            return false;
        }
    }
    // закриваємо повністю браузер, як саму сутність
    @After
    public void tearDown(){
        webDriver.quit();
    }



}
