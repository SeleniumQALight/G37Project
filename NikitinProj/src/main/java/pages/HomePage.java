package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy (xpath = ".//*[@class='pull-left image']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;

    @FindBy(id="prov_cus")
    private WebElement subMenuDealType;


    public HomePage(WebDriver webDriver) {

        super(webDriver, "/");
    }

    public boolean isAvatarDisplayed(){
        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

    public void clickOnSubMenuDealType(){
        actionsWithOurElements.clickOnElement(subMenuDealType);
    }
}
