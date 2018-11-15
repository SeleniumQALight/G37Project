package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

abstract public class Parent_page {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public Parent_page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
