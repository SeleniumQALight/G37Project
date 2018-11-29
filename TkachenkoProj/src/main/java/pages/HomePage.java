package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatarLogo;
    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy(xpath = ".//*[@id='spares']/a")
    private WebElement subMenuSpare;



    public HomePage(WebDriver driver) {
        super(driver, "/");
    }
    public boolean isAvatarDisplayed(){
       return actionsWithOurElements.isElementDisplayed(avatarLogo);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

}
