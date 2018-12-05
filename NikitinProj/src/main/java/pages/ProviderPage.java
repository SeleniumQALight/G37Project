package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ProviderPage extends ParentPage{

    EditProviderPage editProviderPage;

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public ProviderPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");

    }

    public void clickOnAddButton(){
        actionsWithOurElements.clickOnElement(buttonAdd);
    }






}
