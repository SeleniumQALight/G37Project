package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image'] ")
   private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id= "spares")
    private WebElement subMenu;

    @FindBy(id= "prov_cus")
    private WebElement subMenuProviders;



    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }


    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplayed(avatar);

//        try {
//            return avatar.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenu);
    }

    public void clickOnSubMenuProviders() {
        actionsWithOurElements.clickOnElement(subMenuProviders);
    }
}

