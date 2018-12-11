package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy (id = "spares_spareName")
    private WebElement spareNameInput;
    @FindBy (id = "spares_spareType")
    private WebElement spareTypeDropdown;
    @FindBy (xpath = "//option[@value='1']")
    private WebElement valueFromDD;
    @FindBy (name = "delete")
    private WebElement buttonDelete;
    @FindBy(name = "add")
    private WebElement buttonCreate;

    public EditSparePage(WebDriver driver) {
        super(driver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput(String spareName){
        return spareNameInput.getAttribute("value").equals(spareName);
    }
    public void clickOnButtonDelete(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD(spareTypeDropdown,spareType);
    }
    public void selectSpareTypeFromDD(String spareType){
        actionsWithOurElements.selectElementFromDropdownByText(spareTypeDropdown,spareType);
    }
}
