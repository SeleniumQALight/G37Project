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

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spare/edit");
    }

    public boolean checkSpareNameInInput(String spareName) {
        return spareNameInput.getAttribute("value").equals(spareName);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameInToInput(String spareName){
        actionsWithOurElements.enterTextInToElement(spareNameInput, spareName);
    }

    public void clickButtonCreate(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void selectSpareTypeInDD(String spareType){
        actionsWithOurElements.selectTextInDD(spareTypeDD, spareType);
    }

    public void selectSpareTypeInDDManual(String spareType){
        actionsWithOurElements.selectTextInDDManual(spareTypeDD, spareType);
    }

}
