package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    EditSparePages editSparePage;
    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    @FindBy (xpath = ".//i[@class= 'fa fa-plus']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePages(webDriver);
    }

    @Deprecated
    public void checkAndDeleteSpace(String spareName) {
        EditSparePages editSparePages = new EditSparePages(webDriver);
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
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

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)) {
            clickOnSpare (spareName);
            editSparePage.clickButtonDelete();
            counter++;
            if (counter > 100) {
                Assert.fail("There are more then 100 spare in list" +
                        "or deleting does not work, so text does not go further");
            }
        }
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//[text()='" + spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName)); //метод кликает по элементу getSpare...
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//[text()='" + spareName + "']")); //в локатор вклеиваем spareName
    }
}

