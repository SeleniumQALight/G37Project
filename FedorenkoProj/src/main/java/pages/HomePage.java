package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//*[@class='pull-left image']") private WebElement avatar;
    @FindBy (xpath = ".//*[@id='dictionary']/a") private WebElement menuDictionary;
    @FindBy (id = "spares") private WebElement SubMenuSpares;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
    public boolean isAvatarPresent(){
        return actionsWithOurElements.isElementPresent(avatar);
//        try {
//            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']"))
//                    .isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(SubMenuSpares);
    }
}
