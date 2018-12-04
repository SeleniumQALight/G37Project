package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends Parent_page {

    EditProvidersPage editProvidersPage;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editProvidersPage = new EditProvidersPage(webDriver);
    }

    @FindBy (xpath = ".//i[@class = 'fa fa-plus']")
    WebElement addNewProvidersButton;


    public void clickOnAddNewProvidersButton() {
        actionsWithOurElements.clickOnElement(addNewProvidersButton);

    }

    public void deleteCertainProviderUntilPresent(String providerFNameValue) {
        int counter = 0;
        while (isProviderInList(providerFNameValue)){
            clickOnCertainProviderRecord(providerFNameValue);
            editProvidersPage.clickOnDeleteProviderButton();
            counter++;
            if (counter > 50){
                Assert.fail("Too many elements with such names (over 50), please, recheck is everything is OK!");
            }

        }

    }

    public boolean isProviderInList(String providerFNameValue){
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + providerFNameValue + "']"));
    }

    public void clickOnCertainProviderRecord(String providerFNameValue){
        actionsWithOurElements.clickOnElement(getProviderWithCertainFName(providerFNameValue));
    }

    private WebElement getProviderWithCertainFName (String providerFNameValue){
        return webDriver.findElement(By.xpath(".//*[text()='" + providerFNameValue + "']"));
    }

    //    .//tr[.//td[text()='test1112']]//td[4]//span[text()='1']

    public boolean isProoviderInListAsFizlitso (String providerFNameValue){
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//tr[.//td[text()='" + providerFNameValue + "']]//td[4]//span[text()='1']"));
    }
}
