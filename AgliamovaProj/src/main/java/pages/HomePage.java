package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='pull-left image']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy (id = "spares")
    private WebElement subMenuSpares;

    public HomePage (WebDriver webDriver) {
        super(webDriver, "/");
    }

    @Step
    public boolean isAvatarDisplayed() {
//        try{
//            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
////
////        }catch (Exception e){
////            return false;
////        }
//    }
        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }

}
