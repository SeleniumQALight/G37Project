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


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionWithOurElements = new ActionWithOurElements(webDriver);

    }



}



