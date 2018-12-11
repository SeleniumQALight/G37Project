package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProvidersPage extends ParentPage {
    EditProvidersPage editProvidersPage;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editProvidersPage = new EditProvidersPage(webDriver);
    }

    @FindBy(xpath = ".//table/tbody/tr")
    private List<WebElement> listOfRows;

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    @FindBy(xpath = "//*[@class='label label-success']")
    private WebElement labelPrivate;


    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void deletingProviderUntilPresent(String provider) {
        int counter = 0;
        while (isProviderInList(provider)) {
            clickOnProvider(provider);
            editProvidersPage.clickButtonDelete();
            logger.info(provider + " deleted successfully");
            counter++;
            if (counter > 100) {
                Assert.fail("There are more than 100 providers in list or deleting does not work, so test does not go further.");
            }
        }
    }

    public boolean isProviderInList(String provider) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//table/tbody/tr/td[1][text()='" + provider + "']"));
    }

    private void clickOnProvider(String provider) {
        actionsWithOurElements.clickOnElement(getProviderWithName(provider));
    }

    public WebElement getProviderWithName(String provider) {
        return webDriver.findElement(By.xpath(".//table/tbody/tr/td[1][text()='" + provider + "']"));
    }

    public WebElement getProviderLabelWithName(String provider) {
        return webDriver.findElement(By.xpath("//table//tr[td[text()='" + provider + "']]//span"));
    }
}
