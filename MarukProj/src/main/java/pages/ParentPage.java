package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    String baseUrl;
    String expectedUrl;

    // constructor  Alt+Insert
    public ParentPage(WebDriver webDriver,String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this); // фізично ініціалізує елементи на сторінці
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        baseUrl = configProperties.base_url();
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
