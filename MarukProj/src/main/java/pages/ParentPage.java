package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    // constructor  Alt+Insert
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this); // фізично ініціалізує елементи на сторінці
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }
}
