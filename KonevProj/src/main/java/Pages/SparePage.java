package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {

    @FindBy(xpath = ".//table//tr//td[1]") //находит все элементы по этому икспасу и записывает в список
            List<WebElement> listOfRows;
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
//
//        String test;
//        if (listOfRows.size()>0){
//        for (WebElement line:listOfRows) {
//            WebElement cellWithSpare = line;//.findElement(By.xpath("//td[1]"));
//            test = cellWithSpare.getText();
//            if (cellWithSpare.getText().equals(spareName)) {
//               actionsWithOurElements.clickOnElement(cellWithSpare);
//                Assert.assertFalse("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
//                editSparePage.clickButtonDelete();
//                listOfRows.remove(line);
//            }
//        }
//    }
        for (int i = 0; i < listOfRows.size(); i++) {
            if (listOfRows.get(i).getText().equals(spareName)) {
                actionsWithOurElements.clickOnElement(listOfRows.get(i));
                Assert.assertTrue("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
                editSparePage.clickButtonDelete();
                i--;
            }
        }

    }


    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()=" + spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement((getSpareWithName(spareName)));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
