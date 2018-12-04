package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Parent_page {

    @FindBy (xpath=".//a[@class='dropdown-toggle']")
    private WebElement avatar;

    @FindBy (xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy (xpath = ".//li[@id='spares']")
    private WebElement subMenuSpare;

    @FindBy (xpath = ".//a[@href ='/dictionary/providers']")
    private WebElement subMenuProviders;


    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }


    public boolean isAvatarDisplayed() {
//        try {
//            return avatar.isDisplayed();
//        } catch (Exception e) {
//            return false;
        return actionsWithOurElements.isElementDisplayed(avatar);
        }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

    public void clickOnSubMenuProviders() {
        actionsWithOurElements.clickOnElement(subMenuProviders);
    }
}



