package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparesPage extends ParentPage {

    SparesEditPage sparesEditPage;
    @FindBy(xpath = ".//table//tr")
    List<WebElement> listOfRows;
    @FindBy(xpath = ".//a[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        sparesEditPage = new SparesEditPage(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    @Deprecated
    public void checkAndDeleteSpare(String spareName) {
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
                if (cellWithSpare.getText().equals(spareName))
                //   (cellWithSpare.getText().trim().equals(spareName))      trim уберает пробелы в начале и в конце
                {
                    actionsWithOurElements.clickOnElement(cellWithSpare);
                    logger.info("Yes!!!");
                    Assert.assertEquals("Diff Spare", sparesEditPage.checkSpareNameInInput(spareName));
                    sparesEditPage.clickDeleteButton();
                    logger.info("Spare with name was deleted");
                }
            }
        }
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)){
            clickOnSpareName(spareName);
            sparesEditPage.clickDeleteButton();
            counter++;
            if (counter > 100){
                Assert.fail("There are more than 100 spare in list or deleting does not work, so test does not go further");
            }
        }
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    private void clickOnSpareName(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }
}
