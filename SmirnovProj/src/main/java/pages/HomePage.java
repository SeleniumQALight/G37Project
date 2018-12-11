package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']")
    WebElement AvatarPresent;

    @FindBy(xpath = ".//*[@class='pull-left image']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;


    public HomePage(WebDriver webDriver) {
        super(webDriver,"/");
    }

//   public boolean isAvatarPresent(){
//        try{
//            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
//    }

//       public boolean isAvatarPresent(){
//        try{
//            return avatar.isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
//    }


    public void chekVisibleisAvatarPresent() {
        actionsWithOurElements.cheсkVisibleElement(AvatarPresent);
    }

    public boolean isAvatarDisplayed() {
        return actionsWithOurElements.isElementDispayed(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}
