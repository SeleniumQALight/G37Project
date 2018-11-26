package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 123 on 20.11.2018.
 */
public class HomePage extends ParentPage{

    @FindBy(xpath = " .//*[@class='pull-left image']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy (id = "spares")
    private WebElement subMenuSpare;



    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
    public boolean isAvatarPresent(){
        return actionWithOurElements.isElementDisplayed(avatar);

//        try {
//            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']"))
//                    .isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
    }



    public  void clickOnMenuSpare() {
        actionWithOurElements.clickOnElement(menuDictionary);
    }

    public void subMenuSpare() {
        actionWithOurElements.clickOnElement(subMenuSpare);
    }
}
