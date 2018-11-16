package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonVhod;


    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLogInPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        }catch(Exception e){
            logger.error("Cannot open Login Page!");
            Assert.fail("Cannot open Login Page!"); // stop test without any checking

        }
    }


    public void enterLogin(String login) {
       actionsWithOurElements.enterTextInToElement(inputLogin,login);
    }


    public void enterPassword(String password) {
        actionsWithOurElements.enterTextInToElement(inputPassWord,password);
    }

    public void clickButtonVhod() {
        try{
            webDriver.findElement(By.tagName("button")).click();
            logger.info("Authorization passed correctly and user was navigated to Homepage");
        }catch(Exception e){
            logger.info("Cannot work with current element");
            Assert.fail("Test cannot be continued");


        }



    }

}
