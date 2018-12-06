package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProviderPage extends ParentPage{

    EditProviderPage editProviderPage;

    @FindBy(xpath = "//table/tr")
    List<WebElement> listOfRows;

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public ProviderPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");

    }

    public void clickOnAddButton(){
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void deletingUntilPresent(String providerName) {
        int counter = 0;
        while (isProviderInList(providerName)){
            clickOnProvider(providerName);
            editProviderPage.clickButtonDelete();
            counter++;
            if (counter > 100){
                Assert.fail("there are more then 100 spare in the list or delete doesn't work");
            }
        }
    }

    public boolean isProviderInList(String providerName){
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + providerName + "']"));

    }

    private WebElement getProviderWithName(String providerName){
        return webDriver.findElement(By.xpath(".//*[text()='" + providerName + "']"));
    }

    private void clickOnProvider(String providerName){
        actionsWithOurElements.clickOnElement(getProviderWithName(providerName));
    }



}
