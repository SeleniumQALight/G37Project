package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends Parent_page {

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    @FindBy (xpath = ".//i[@class= 'fa fa-plus']")
    WebElement addSpareButton;


    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    EditSparePage editSparePage = new EditSparePage(webDriver);

    public  void clickOnAddButton(){
        actionsWithOurElements.clickOnElement(addSpareButton);
    }


    public void checkAndDeleteSpare(String spareName) {
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//td[1]"));
                if (cellWithSpare.getText().equals(spareName)) {
                    actionsWithOurElements.clickOnElement(cellWithSpare);

                    Assert.assertTrue("Different Spare Name!!!", editSparePage.checkSpareNameInInput(spareName));
                    editSparePage.clickOnDeleteButton();


                }

            }

        }
    }
}