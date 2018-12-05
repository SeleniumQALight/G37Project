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
    }

    String newProvider = "ZhukovaProvider";
    String newProviderAddress = "Address";

    String checkboxprivatPerson = "1";
    String providerEssence = String.format(".//*[td[1][contains(., %s)] and td[2][contains(., %s)] and td[4]/span[contains(text(), '%s')]]",
           newProvider, newProviderAddress, checkboxprivatPerson);

    @FindBy(xpath = ".//a/*[@class='fa fa-plus']")
    WebElement buttonAdd;

//    @FindBy(xpath = providerEssence)
//    private WebElement newProviderEssence;

    By newProviderEssence = (By.xpath(providerEssence));


    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList() {
        return actionsWithOurElements.isElementDisplayed( webDriver.findElement(newProviderEssence));
    }

    public void deletingProviderEssenceUntilPresent() {
        int counter = 0;
        while (isProviderInList()) {
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
        return webDriver.findElement(By.xpath (String.format(".//td[1][contains(., %s)]", newProvider)));

    }
}