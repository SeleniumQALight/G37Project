package pages.pageWithElementsAndElements;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

abstract public class ParentElements {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    public ParentElements(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}

