package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//table//tr")
    List<WebElement> ListOfRows;

    @FindBy(xpath = "//*[@class = 'fa fa-plus']")
    private  WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        if (ListOfRows.size() > 0) {
            for (WebElement line : ListOfRows) {
                WebElement cellsWithSpare = line.findElement(By.xpath("//td[1]"));
                if (cellsWithSpare.getText().equals(spareName)) {
                    actionsWithOurElements.clickOnElement(cellsWithSpare);

                    Assert.assertTrue("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
                    editSparePage.clickButtonDelete();

                }
            }
        }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
