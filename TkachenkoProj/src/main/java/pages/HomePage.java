package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy(xpath = ".//*[@class='pull-left image']")
    WebElement avatarLogo;


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isAvatarPresent(){
        try {
            return avatarLogo.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
