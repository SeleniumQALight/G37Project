package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage {
    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver driver) {
        this.driver = driver;
    }
}
