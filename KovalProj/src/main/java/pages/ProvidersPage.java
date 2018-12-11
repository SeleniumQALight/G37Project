package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {

    ProviderEditPage providerEditPage;
    @FindBy (xpath = ".//a[@href = 'http://v3.test.itpmgroup.com/dictionary/providers/edit']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        providerEditPage = new ProviderEditPage(webDriver);
    }

    public void deletingProviderUntilPresent(String spareName) {
        int counter = 0;
        while (isProviderInList(spareName)){
            clickOnProviderName(spareName);
            providerEditPage.clickOnDeleteButton();
            counter++;
            if (counter > 100){
                Assert.fail("There are more than 100 spare in list or deleting does not work, so test does not go further");
            }
        }
    }

    public boolean isProviderInList(String providerName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//tr[.//td[text() = 'koval']]//span[@class='label label-success']"));
        //return actionsWithOurElements.isElementDisplayed(By.xpath(".//table[@class='table table-hover']//tr[.//td[contains(text(),'" + providerName + "')]]//td[@class = 'label label-success']"));
    }

    private void clickOnProviderName(String providerName) {
        actionsWithOurElements.clickOnElement(getProviderWithName(providerName));
    }

    private WebElement getProviderWithName(String providerName) {
        return webDriver.findElement(By.xpath(".//tr[.//td[text() = 'koval']]//span[@class='label label-success']"));
        //return webDriver.findElement(By.xpath(".//*[text()='" + providerName + "']"));
    }

    public void clickOnAddButton(){
        actionsWithOurElements.clickOnElement(buttonAdd);
    }


}
