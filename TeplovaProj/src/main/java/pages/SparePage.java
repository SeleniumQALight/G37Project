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
    EditSparePage editSparePage;

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfElements;

    @FindBy (xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

//    @FindBy (name = "add")
//    private WebElement buttonCreate;



    public SparePage(WebDriver webDriver) {

        super(webDriver,"/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }
    @Deprecated
    public void checkAndDeleteSpare(String spareName) {
        if ( listOfElements.size() >0)

        {
            for (WebElement list : listOfElements) {
                EditSparePage editSparePage = new EditSparePage(webDriver);

                WebElement cellWithSpare = list.findElement(By.xpath("//*[1]"));
                if (cellWithSpare.findElement(By.xpath("td[1]")).getAttribute("value").equals(spareName)) {
                    actionWithOurElements.clickOnElement(cellWithSpare);
//                logger.info("Yes");
                    Assert.assertTrue("Diff Spare", editSparePage.ckeckSpareNameInInput(spareName));
                    editSparePage.clickDeleteButton();
                }
            }
        }
    }


    public void clickOnButtonAdd() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }


    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while(isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickDeleteButton();
            counter++;
            if (counter >100){

                Assert.fail("More than 100 items");

            }
        }

    }

    public boolean isSpareInList(String spareName) {
        return   actionWithOurElements.isElementDisplayed(By.xpath(".//*[text()='"+ spareName+ "']"));
    }

    private void clickOnSpare(String spareName) {
        actionWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='"+ spareName+ "']"));
    }
}

