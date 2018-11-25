package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    String baseUrl = "http://v3.test.itpmgroup.com";
    String expectedUrl;

    // constructor  Alt+Insert
    public ParentPage(WebDriver webDriver,String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this); // фізично ініціалізує елементи на сторінці
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        this.expectedUrl = baseUrl + relativeUrl;  //склеюємо доменне імя + нашу сторінку

    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkUrl(){
        try{
            Assert.assertEquals("Url is not expected",expectedUrl,getCurrentUrl());

        }catch(Exception e){
            logger.error("Cannot work with url");
            Assert.fail("Cannot work with url");

        }

    }


}
