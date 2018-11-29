package pages;

import libs.ActionWithOurElements;
import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by 123 on 13.11.2018.
 */
abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger((getClass()));
    ActionWithOurElements actionWithOurElements;
    String baseUrl = "http://v3.test.itpmgroup.com ";
    String expectedUrl;


    public ParentPage(WebDriver webDriver, String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionWithOurElements = new ActionWithOurElements(webDriver);
        logger = Logger.getLogger(getClass());
        this.expectedUrl = baseUrl + relativeUrl;

    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }
    public void CheckUrl(){
        try{
            Assert.assertEquals("Url is not expacted",
                    expectedUrl, getCurrentUrl());
        }catch (Exception e){
            logger.error("can't wprk with url");
            Assert.fail();
        }
    }



}



;