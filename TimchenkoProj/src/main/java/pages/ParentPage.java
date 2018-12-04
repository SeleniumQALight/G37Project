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
    Logger logger=Logger.getLogger( getClass());
    ActionsWithOurElements actionsWithOurElements;
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expactedUrt;



    public ParentPage (WebDriver webDriver,String relativeUrl) {
        this.webDriver =webDriver;
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        baseUrl = configProperties.base_url();
        logger = Logger.getLogger(getClass());
        expactedUrt = baseUrl + relativeUrl;
    }
 public String getCurrentUrl () {

        return  webDriver.getCurrentUrl();
 }

  public  void  checkUrl () {
        try { Assert.assertEquals( "Url in not expected", expactedUrt, getCurrentUrl());

        } catch ( Exception e) {

            logger.error("Can not work with utl");
            Assert.fail("Can not work with utl");
        }

  }
}


