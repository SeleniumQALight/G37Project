package pages;

import org.openqa.selenium.WebDriver;

public class SparePage extends ParentPage{
    public SparePage(WebDriver webDriver) {  //deleted part - second param String relativeUrl
        super(webDriver, "/dictionary/spares");
    }
}
