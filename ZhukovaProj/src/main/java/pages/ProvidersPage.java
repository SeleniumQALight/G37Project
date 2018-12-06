package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    EditProvidersPage editProvidersPage;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editProvidersPage  = new EditProvidersPage(webDriver);
    }


    String providerEssence = ".//*[td[1][contains(., '%s')]] [td[4]/span[contains(text(), '%s')]]";

    @FindBy(xpath = ".//a/*[@class='fa fa-plus']")
    WebElement buttonAdd;

//    @FindBy(xpath = providerEssence)
//    private WebElement newProviderEssence;

    By newProviderEssence = (By.xpath(providerEssence));


    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList(String newProvider, String checkboxprivatPerson) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(String.format(providerEssence, newProvider, checkboxprivatPerson)));
    }

    public void deletingProviderEssenceUntilPresent(String newProvider, String checkboxProviderPerson) {
        int counter = 0;
        while (isProviderInList(newProvider,  checkboxProviderPerson)) {
            clickOnProviderName(newProvider);
            editProvidersPage.clickButtonDeleteOnEditProviderPage();
            counter++;
            if (counter > 100) {
                Assert.fail("There are more then 100 provider in list or deleting does not work.");
            }
        }
    }

    private void clickOnProviderName(String newProvider) {
        actionsWithOurElements.clickOnElement(getProviderWithName(newProvider));
    }
    private WebElement getProviderWithName(String newProvider) {
        return webDriver.findElement(By.xpath (String.format(".//td[1][contains(., '%s')]", newProvider)));

    }
}