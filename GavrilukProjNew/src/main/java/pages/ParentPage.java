package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger ;
    ActionsWithOurElements actionsWithOurElements;
    String baseUrl = "http://v3.test.itpmgroup.com";
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        logger = Logger.getLogger(getClass());
        expectedUrl = baseUrl + relativeUrl;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkUrl(){
        try {
            Assert.assertEquals("Url is not expected"
                    , expectedUrl, getCurrentUrl());
        }catch (Exception e){
            logger.error("Can not work with url");
            Assert.fail("Can not work with url");
        }
    }
}
