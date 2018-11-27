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

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput(String spareName) {
        return spareNameInput.getAttribute("value").equals(spareName);
    }

    public void clickDeleteOnElement() {
        actionsWithOurElements.clickOnElement(buttonDelete);

    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void selectSpareTypeInDropDown(String spareType) {
        actionsWithOurElements.selectTextInDropDown(spareTypeDD, spareType);
    }

    public void clickOnAddButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
}