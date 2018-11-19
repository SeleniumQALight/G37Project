package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends  ParentPage {

    @FindBy (name ="_username")
    WebElement inputLogin;
    @FindBy (name ="_password")
    WebElement inputPassWord;
    @FindBy (tagName ="button")
    WebElement buttonEnter;

    public LogInPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void openLogInPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }

    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin,login);
    }

    public void enterPassWord(String passWord) {
       // try {
        //    inputPassWord.clear();
       //   inputPassWord.sendKeys(passWord);


       //     logger.info(passWord + "was inputed into Input");

      //  } catch (Exception e) {
      //      logger.error("Can not work with element");
        //    Assert.fail("Can not work with element");
      //  }

        actionsWithOurElements.enterTextIntoElement(inputPassWord,passWord);
    }

    public void clickButtonEnter() {
        actionsWithOurElements.clickOnElement  (buttonEnter);
      //  try {
        //    webDriver.findElement(By.xpath("//button[@type='submit']")).click();

          //  logger.info("The enter is successful");

       // } catch (Exception e) {
         //   logger.error("Can not find the element");
           // Assert.fail("Can not find the element");
        }




    public void loginInToApp (String login, String passWord) {
        openLogInPage();
        enterLogin(login);
        enterPassWord(passWord);
        clickButtonEnter();
    }
        public boolean isButtonPresent() {
            try {
                return webDriver.findElement(By.tagName("button")).isDisplayed();
            }catch(Exception e){
                return false;
            }
        }

    }


     /*   public void clickStudentButton () {


            try {
                webDriver.findElement(By.className("sidebar-toggle")).click();
                logger.info("Student button is found");

            } catch (Exception e) {
                logger.error("Can not find the Student button");
                Assert.fail("Can not find the Student button");
            }
        }

    public void exitButton () {


        try {
            webDriver.findElement(By.id("Выход")).click();
            logger.info("The exit is successful");

        } catch (Exception e) {
            logger.error("Can not find the Exit button");
            Assert.fail("Can not find the Exit button");
        }
    }
*/


