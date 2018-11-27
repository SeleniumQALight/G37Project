package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    //@FindBy(xpath = "//*[@class = 'fa fa plus']")
    @FindBy(xpath = "//*[@href = 'http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement buttonAdd;


    public SparePage(WebDriver webDriver) {  //deleted part - second param String relativeUrl
        super(webDriver, "/dictionary/spares");
    }

    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        if (listOfRows.size() > 0){
        for (WebElement line:listOfRows) {
            WebElement cellWithSpare = line.findElement(By.xpath("//*[@id='device_list']//td[1]"));
            if (cellWithSpare.getText().equals(spareName)) {
                actionsWithOurElements.clickOnElement(cellWithSpare);
                Assert.assertTrue("different spare",editSparePage.checkSpareNameInInput(spareName));
                editSparePage.clickButtonDelete();
            }
        }
    }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
