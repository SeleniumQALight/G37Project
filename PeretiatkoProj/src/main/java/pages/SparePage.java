package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SparePage extends ParentPage {

    @FindBy(xpath = ".//table/tr")
    private List<WebElement> listOfRows;

    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void checkAndDeleteSpare(String spareName) {
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                EditSparePage editSparePage = new EditSparePage(webDriver);
                WebElement cellWithSpare = line.findElement(By.xpath("/td[1]"));
                if (cellWithSpare.getText().trim().equals(spareName)) ;
                actionsWithOurElements.clickOnElement(cellWithSpare);
                //logger.info("Yes!!!");

                Assert.assertTrue("Diff spare", editSparePage.checkSpareNameInInput(spareName));
                editSparePage.clickDeleteOnElement();
            }
        }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
