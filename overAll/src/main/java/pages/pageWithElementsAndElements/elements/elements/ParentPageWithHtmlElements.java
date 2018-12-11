package pages.pageWithElementsAndElements.elements.elements;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

abstract public class ParentPageWithHtmlElements {
    WebDriver webDriver;
    Logger logger ;
    ActionsWithOurElements actionsWithOurElements;
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;

    public ParentPageWithHtmlElements(WebDriver webDriver, String relativeUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        baseUrl=configProperties.base_url();
        logger = Logger.getLogger(getClass());
        expectedUrl = baseUrl + relativeUrl;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkUrl(){
        try {

            Assert.assertEquals("Url is not expected"
                    , expectedUrl, getCurrentUrl());
            logger.info(getClass().getSimpleName() + " - Url is OK");
        }catch (Exception e){
            logger.error("Can not work with url");
            Assert.fail("Can not work with url");
        }
    }
}
