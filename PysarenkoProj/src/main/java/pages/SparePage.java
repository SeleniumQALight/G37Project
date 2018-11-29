package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends Parent_page {

    EditSparePage editSparePage;

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    @FindBy (xpath = ".//i[@class= 'fa fa-plus']")
    WebElement addSpareButton;


    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }


    public  void clickOnAddButton(){
        actionsWithOurElements.clickOnElement(addSpareButton);
    }

    @Deprecated
    public void checkAndDeleteSpare(String spareName) {
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
                if (cellWithSpare.getText().equals(spareName)) {
                    actionsWithOurElements.clickOnElement(cellWithSpare);

                    Assert.assertTrue("Different Spare Name!!!", editSparePage.checkSpareNameInInput(spareName));
                    editSparePage.clickOnDeleteButton();


                }

            }

        }
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickOnDeleteButton();
            counter++;
            if (counter >100) {
                Assert.fail("There are more than 100 spare in list or deleting doesn't work, so test doesn't go further");
            }

        }
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }
}