package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProvidersPage extends ParentPage {
    EditProvidersPage editProvidersPage;
    @FindBy (xpath="//table//td")
    List<WebElement> listOfProviders;

    @FindBy (xpath="//*[@class='fa fa-plus']")
    WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editProvidersPage = new EditProvidersPage(webDriver);
    }

    @Deprecated
    public void checkAndDeleteProvider(String providerName){
        if (listOfProviders.size()>0){
            for (WebElement line: listOfProviders) {
                WebElement cellWithProvider = line.findElement(By.xpath("//*[1]"));
                if (line.findElement(By.xpath("//td[1]")).getText().equals(providerName)) {
                    actionsWithOurElements.clickOnElement(cellWithProvider);
                    Assert.assertTrue("Different Spare", editProvidersPage.checkProviderNameInInput(providerName));
                    editProvidersPage.clickButtonDelete();
                }
            }
        }
    }

    public void deletingProviderIfPresent(String providerName) {
        int counter = 0;
        while (isInProvidersList(providerName)){
            clickOnProvider(providerName);
            editProvidersPage.clickButtonDelete();
            counter++;
                if (counter>100){
                    Assert.fail("There are more then 100 providers in the list " + "or deleting does not work, so test does not go further");
                }
        }

    }

    private void clickOnProvider(String providerName) {
        actionsWithOurElements.clickOnElement(getProviderWithName(providerName));
    }

    private WebElement getProviderWithName(String providerName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + providerName + "']"));
    }

    public boolean isInProvidersList(String providerName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + providerName + "']"));
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
