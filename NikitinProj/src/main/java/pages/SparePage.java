package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    EditSparePage editSparePage ;

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    //@FindBy(xpath = "//*[@class = 'fa fa plus']")
    @FindBy(xpath = "//*[@href = 'http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {  //deleted part - second param String relativeUrl
        super(webDriver, "/dictionary/spares");
        editSparePage =  new EditSparePage(webDriver);
    }

    @Deprecated
    public void checkAndDeleteSpare(String spareName) {

        if (listOfRows.size() > 0){
        for (WebElement line:listOfRows) {
            WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
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

    public void deletingUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickButtonDelete();
            counter++;
            if (counter > 100){
                Assert.fail("there are more then 100 spare in the list or delete doesn't work");
            }
        }
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }
}
