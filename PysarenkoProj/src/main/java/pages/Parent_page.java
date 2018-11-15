package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class Parent_page {
    WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;

    public Parent_page(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
