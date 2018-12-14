package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement userPanelIcon;
    @FindBy(xpath = ".//*[@id='dictionary']//a")
    private WebElement menuDictionary;
    @FindBy(id = "spares")
    public WebElement subMenuSpare;
    @FindBy (xpath = ".//a[@href = '/dictionary/providers']")
    private WebElement subMenuProviders;


    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @Step
    public boolean isAvatarDisplayed(){
       return actionsWithOurElements.isElementDisplayed(userPanelIcon);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

    public void clickOnSubMenuProviders(){
        actionsWithOurElements.clickOnElement(subMenuProviders);
    }
}
