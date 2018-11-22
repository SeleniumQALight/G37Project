package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparesPage extends ParentPage {

    @FindBy(xpath = ".//table//tr")
    List<WebElement> listOfRows;
    @FindBy(xpath = ".//a[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void checkAndDeleteSpare(String spareName) {
        SparesEditPage sparesEditPage = new SparesEditPage(webDriver);
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//td[1]"));
                if (cellWithSpare.getText().equals(spareName))
                //   (cellWithSpare.getText().trim().equals(spareName))      trim уберает пробелы в начале и в конце
                {
                    actionsWithOurElements.clickOnElement(cellWithSpare);
                    logger.info("Yes!!!");
                    Assert.assertEquals("Diff Spare", sparesEditPage.checkSpareNameInInput(spareName));
                    sparesEditPage.clickDeleteButton();
                }
            }
        }
    }
}
