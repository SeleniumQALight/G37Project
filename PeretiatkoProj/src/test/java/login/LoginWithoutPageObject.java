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

import static line.Prop.*;


public class LoginWithOutPageObject {
    WebDriver webDriver;

    private void beforeTestStart() {
        File file = new File(SRC_CHROME);
        System.setProperty(SET_PROPERTY, file.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(AVATAR)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isLoginPageStay(){
        try {
            return webDriver.findElement(By.xpath(LOGIN_PAGE)).isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }

    private void afterTest() {
        webDriver.quit();
    }

    private void urlSite() {
        webDriver.get(URL_SITE);
    }

    private void passLocClear() {
        webDriver.findElement(By.name(USER_LOC)).clear();
    }

    private void buttonClick() {
        webDriver.findElement(By.tagName(BUTTON)).click();
    }

    private void assertAvatar() {
        Assert.assertTrue(EXC_AVATAR, isAvatarPresent());
    }

    private void wrongPass() {
        webDriver.findElement(By.id(PASS_LOC)).sendKeys(WRONG_PASSWORD);
    }

    private void wrongLogin() {
        webDriver.findElement(By.name(USER_LOC)).sendKeys(WRONG_LOGIN);
    }

    private void passWord() {
        webDriver.findElement(By.id(PASS_LOC)).sendKeys(PASSWORD);
    }

    private void loGin() {
        webDriver.findElement(By.name(USER_LOC)).sendKeys(LOGIN);
    }

    @Before
    public void setUp() {
        beforeTestStart();
    }

    @Test
    public void validLogIn() {
        urlSite();
        loGin();
        passLocClear();
        passWord();
        passLocClear();
        buttonClick();
        isAvatarPresent();
}

    @Test
    public void inValidLogIn() {
        urlSite();
        passLocClear();
        wrongLogin();
        passLocClear();
        wrongPass();
        buttonClick();
        isLoginPageStay();
    }

    @After
    public void tearDowns() {
        afterTest();
    }
}
