package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


abstract class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithElements actionsWithElements;
    String baseUrl = "http://v3.test.itpmgroup.com";
    String exprctedUrl;

    public ParentPage(WebDriver webDriver, String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithElements = new ActionsWithElements(webDriver);
        this.exprctedUrl = baseUrl + relativeUrl;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkUrl(){
        try {
            Assert.assertEquals("Url is not expected" + exprctedUrl, getCurrentUrl());
        }catch (Exception e){
            logger.error("Cannot work with URL");
            Assert.fail("Cannot work with URL");
        }
    }
}
