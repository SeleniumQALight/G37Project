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

    @FindBy(xpath = "//option[@value='1']")
    private WebElement spareTypeDDByValue;

    //xpath for the механика1 spare type from the DD
    @FindBy(xpath = "//option[text()='Механика1']")
    private WebElement spareTypeDDByText;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput(String spareName){
        return spareNameInput.getAttribute("value").equals(spareName);
    }

    public void clickButtonDelete(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

//    public void selectSpareTypeInDD(String spareType) {
//        actionsWithOurElements.selectTextInDD(spareTypeDD, spareType);
//    }

    //this method uses text of the item from DD
    public void selectSpareTypeInDDByText(String spareType){
        actionsWithOurElements.clickOnElement(spareTypeDD);
        actionsWithOurElements.clickOnElement(spareTypeDDByText);
    }

    //this method uses value of the item from DD
    public void selectSpareTypeInDDByValue(String spareType){
        actionsWithOurElements.clickOnElement(spareTypeDD);
        actionsWithOurElements.clickOnElement((spareTypeDDByValue));
    }
}
