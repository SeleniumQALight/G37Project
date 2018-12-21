package pages.pageWithElementsAndElements.elements.elements;

import org.openqa.selenium.WebDriver;

import pages.pageWithElementsAndElements.LeftMenu;


public class WorkersPageWithHtmlElements extends ParentPageWithHtmlElements {

    public LeftMenu leftMenu = new LeftMenu(webDriver);

    public WorkersPageWithHtmlElements(WebDriver webDriver) {
        super(webDriver, "/dictionary/workers");

    }


}
