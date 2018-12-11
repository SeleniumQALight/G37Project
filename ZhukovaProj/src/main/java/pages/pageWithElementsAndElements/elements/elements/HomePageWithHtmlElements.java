package pages.pageWithElementsAndElements.elements.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageWithElementsAndElements.elements.elements.elements.LeftMenu;

public class HomePageWithHtmlElements extends ParentPageWithHtmlElements {
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;
    public LeftMenu leftMenu = new LeftMenu(webDriver);

    public HomePageWithHtmlElements(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @Step
    public boolean isAvatarDislpayed() {
        return actionsWithOurElements.isElementDisplayed(avatar);
    }
}