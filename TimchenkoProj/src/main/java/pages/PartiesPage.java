package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartiesPage extends ParentPage {
    EditPartiesPage editPartiesPage = new EditPartiesPage(webDriver);
    @FindBy (xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

   // public PartiesPage(WebDriver webDriver) {
     //   super(webDriver, "/dictionary/providers");
      //  editPartiesPage = new EditSparePage( webDriver); }

    public PartiesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        editPartiesPage = new EditPartiesPage (webDriver);
    }


    public void clickOnAddButton() { actionsWithOurElements.clickOnElement(buttonAdd); }

    public void deletingPartiesUntilPresent(String partyName) {
        int counter = 0;
        while (isPartyInList (partyName)) {
            clickOnParty (partyName);
            editPartiesPage.clickButtonDelete();
            counter ++;
            if (counter > 100) {

                Assert.fail( "There are more than 100 parties in list" + "or deleting does not work, so test does not go further");
            }

        }

    }

    public boolean isPartyInList(String partyName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + partyName + "']")); }

    private void clickOnParty (String partyName) {actionsWithOurElements.clickOnElement(getPartyWithName (partyName)); }

    private WebElement getPartyWithName(String partyName) { return webDriver.findElement(By.xpath(".//*[text()='" + partyName + "']"));
    }
}
