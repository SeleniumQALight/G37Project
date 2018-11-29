package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//table//tr")
    List<WebElement> listRows;
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    WebElement buttonAdd;



    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage=new EditSparePage(webDriver);
        if (listRows.size() > 0) {


        for (WebElement line:listRows){
            WebElement cellsWithSpare=line.findElement(By.xpath("//td[1]"));
        if (cellsWithSpare.getText().equals(spareName)){
            actionWithOurElements.clickOnElement(cellsWithSpare);
            logger.info("Spare Page");
            logger.info("Element was delete");
            Assert.assertTrue("Diff Spare",editSparePage.checkSpareNameInIntup(spareName));
            editSparePage.clickButtonDelete();

        };

      }

        }
}


    public void clickOnAddButton() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }
}
