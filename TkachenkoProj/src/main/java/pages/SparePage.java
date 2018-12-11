package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    EditSparePage editSparePage;
    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;
    @FindBy(xpath = ".//i[@class='fa fa-plus']")
    private WebElement addButton;

    public SparePage(WebDriver driver) {
        super(driver, "/dictionary/spares");
        editSparePage = new EditSparePage(driver);
    }

    @Deprecated
    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(driver);
        if(listOfRows.size()>0){
        for (WebElement line: listOfRows){
            WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
            if (cellWithSpare.getText().equals(spareName)) {
                actionsWithOurElements.clickOnElement(cellWithSpare);
                Assert.assertTrue("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
                editSparePage.clickOnButtonDelete();
            }
        }
        }
    }

    @Step
    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickOnButtonDelete();
            counter++;
            if (counter >100){
                Assert.fail("There are more than 100 spare in list or deleting does not work, so test does not go further ");
            }
        }
    }

    @Step
    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    @Step
    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return driver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }
}
