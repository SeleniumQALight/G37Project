package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Created by 123 on 20.11.2018.
 */
public class SparePage extends ParentPage {

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfElements;

    @FindBy (xpath = "fa fa-plus")
    private WebElement buttonAdd;

    @FindBy (name = "add")
    private WebElement buttonCreate;


    public SparePage(WebDriver webDriver) {
        super(webDriver,"/dictionary/spase");
    }

    public void checkAndDeleteSpare(String spareName) {
        if ( listOfElements.size() >0)

        {
            for (WebElement list : listOfElements) {
                EditSparePage editSparePage = new EditSparePage(webDriver);

                WebElement cellWithSpare = list.findElement(By.xpath("td[1]"));
                if (cellWithSpare.findElement(By.xpath("td[1]")).getText().equals(spareName)) {
                    actionWithOurElements.clickOnElement(cellWithSpare);
//                logger.info("Yes");
                    Assert.assertTrue("Diff Spare", editSparePage.ckeckSpareNameInInput(spareName));
                    editSparePage.clickDeleteButton();
                }
            }
        }
    }


    public void clickOnButton() {
        actionWithOurElements.clickOnElement(buttonCreate);
    }
}

