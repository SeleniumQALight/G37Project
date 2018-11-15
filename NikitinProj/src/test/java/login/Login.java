package login;

import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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


        webDriver.get("http://v3.test.itpmgroup.com/login");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar isn't present",
                isAvatarPresent());

    }

    @Test
    public void invalidLogin(){
        String m = "dsfs";
        webDriver.get("http://v3.test.itpmgroup.com/login");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys(randomizeNumberForInvalidLogin());
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Portal page isn't opened", isAvatarPresent());
    }

    public String randomizeNumberForInvalidLogin(){
       double a = (Math.random())*10;
       String rand = "login"+a;
        return rand;
    }

    private boolean isAvatarPresent(){
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        }catch (Exception e){

        }
        return false;
    }

    @After
    public void tearDown(){
        webDriver.quit();

    }

}
