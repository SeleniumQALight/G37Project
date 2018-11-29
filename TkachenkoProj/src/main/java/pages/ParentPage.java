package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;


    public ParentPage(WebDriver driver, String relativeUrl) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actionsWithOurElements = new ActionsWithOurElements(driver);
        baseUrl = configProperties.base_url();
        this.expectedUrl = baseUrl+relativeUrl;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void checkUrl(){
        try{
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());
        }catch (Exception e){
            logger.error("Can not work with url");
            Assert.fail("Can not work with url");
        }
    }
}
