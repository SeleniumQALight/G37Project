
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {


    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    @FindBy(name = "add")
    private WebElement buttonCreate;


    @FindBy(xpath = ".//*[@value='1']")
    private WebElement value1;

    @FindBy(xpath = ".//*[(text()= 'Механика1')]")
    private WebElement SpareTypeMehanika1;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput(String spareName) {
        return spareNameInput.getText().equals(spareName);

    }

    public void clickButtonDeleteOnEditPage() {

        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameInToInput(String spareName) {

        actionsWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD(spareTypeDD, spareType);
    }


    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }


    public void setSpareTypeDDByName(WebElement element, WebElement elementDD) {

        actionsWithOurElements.clickOnElement(spareTypeDD);
        actionsWithOurElements.clickOnElement(SpareTypeMehanika1);

    }

    public void setSpareTypeDDByValue(WebElement element, WebElement valueDD) {

        actionsWithOurElements.clickOnElement(spareTypeDD);
        actionsWithOurElements.clickOnElement(value1);


    }
}


