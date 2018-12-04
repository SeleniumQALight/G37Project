package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInput(String spareName){
        return spareNameInput.getAttribute("value").equals(spareName);
    }

    public void clickOnButtonDelete(){
        actionsWithElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameIntoInput(String spareName) {
        actionsWithElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeInDropDown(String spareType) {
        actionsWithElements.selectTextInDropDown(spareTypeDropDown, spareType);
    }
}
