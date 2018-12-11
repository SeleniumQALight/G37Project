package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;
    @FindBy(xpath = ".//li[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy(xpath = ".//li[@id='spares']/a")
    private WebElement subMenuSpare;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarDisplayed() {
        return actionsWithElements.isElementDisplayed(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithElements.clickOnElement(subMenuSpare);
    }
}
