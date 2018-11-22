package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePages extends ParentPage {
    @FindBy(id = "space_spareName")
    private WebElement spareNameInput;

    @FindBy (id = "space_spareType")
    private WebElement spareTypeDD;

    @FindBy (name = "delete")
    private WebElement buttonDelete;

    @FindBy (name = "add")
    private WebElement buttonCreate;


    public EditSparePages(WebDriver webDriver) {
        super(webDriver, "/dictionary/spare/edit");
    }

    public boolean checkSpareNameInput (String spareName) {
        return spareNameInput.getText().equals(spareName);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameIntoImput(String spareName) {
        actionsWithOurElements.enterTextInToElement(spareNameInput, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD (spareTypeDD, spareType);
    }
}
