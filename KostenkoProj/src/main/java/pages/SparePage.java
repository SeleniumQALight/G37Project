package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {

    @FindBy (xpath = "//*[@class='fa fa-plus'}")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    public void checkAndDeleteSpace(String spareName) {
        EditSparePages editSparePages = new EditSparePages(webDriver);
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//table//tr[1]/tr[1]"));
                if (cellWithSpare.getText().equals(spareName)) {
                    actionsWithOurElements.clickOnElement(cellWithSpare);

                    Assert.assertTrue("Different Spare"
                            , editSparePages.checkSpareNameInput(spareName));
                    editSparePages.clickButtonDelete();

                }
            }
        }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}

