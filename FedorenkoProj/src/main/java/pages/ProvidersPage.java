package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by user on 04.12.2018.
 */
public class ProvidersPage extends ParentPage {
    EditProvidersPage editProvidersPage;
    @FindBy(xpath = "//i[@class='fa fa-plus']") private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editProvidersPage = new EditProvidersPage(webDriver);
    }

    public void deletingProviderUntilPresent(String providerName) {
        int counter = 0;
        while (isProviderInList(providerName)){
            clickOnProvider(providerName);
            editProvidersPage.clickButtonDelete();
            counter++;
            if (counter>100){
                Assert.fail("There are more than 100 provider in the list or deleting does not work, so test does not go further");
            }
        }
    }

    public boolean isProviderInList(String providerName) {
        return actionsWithOurElements.isElementPresent(By.xpath(".//*[text()= '"+providerName+"']"));
    }

    private void clickOnProvider(String providerName) {
        actionsWithOurElements.clickOnElement(getProviderWithName(providerName));
    }

    private WebElement getProviderWithName(String providerName) {
        return webDriver.findElement(By.xpath(".//*[text()= '"+providerName+"']"));
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
