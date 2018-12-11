package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class Parent_page {
    WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;

    public Parent_page(WebDriver webDriver, String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        baseUrl=configProperties.base_url();
        this.expectedUrl = baseUrl + relativeUrl;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkUrl(){
        try{
            Assert.assertEquals("URL is not expected", expectedUrl, getCurrentUrl());
        }catch (Exception e){
            logger.error("Can not work with URL");
            Assert.fail("Can not work with URL");
        }
    }
}
