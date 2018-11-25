package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends  Parent_page {

    @FindBy (name = "add")
    private WebElement buttonCreate;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }
    @FindBy (id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy (id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy (name = "delete")
    private WebElement buttonDelete;


    public boolean checkSpareNameInInput (String spareName){
        return spareNameInput.getText().equals(spareName);
    }

    public void clickOnDeleteButton(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }


    public void enterSpareNameInToinput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD(spareTypeDD,spareType);


    }
}
