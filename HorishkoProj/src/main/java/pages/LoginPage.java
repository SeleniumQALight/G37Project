package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");

        }catch (Exception e){

            Assert.fail("Cannot open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin,login);

//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + "was inputted into Input");
//        } catch (Exception e) {
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }
        public void enterPassword(String passWord) {
            actionsWithOurElements.enterTextInToElement(inputPassWord,passWord); // ниже код, который делает то же самое

//            try {
//                inputPassWord.clear();
//                inputPassWord.sendKeys(passWord);
////                webDriver.findElement(By.name("_password")).clear();
////                webDriver.findElement(By.name("_password")).sendKeys(passWord);
//                logger.info(passWord + "was inputted into Input");
//            }catch (Exception e){
//                logger.error("Cannot work with element");
//                Assert.fail("Cannot work with element");
//            }
    }
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);

//        try {
//            buttonVhod.click();
// //           webDriver.findElement(By.tagName("button")).click();
//            logger.info("click on button vhod");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }
    public void loginInToApp(String login, String password){
        try {
            openLoginPage();
            enterLogin(login);
            enterPassword(password);
            clickButtonVhod();
        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
}
