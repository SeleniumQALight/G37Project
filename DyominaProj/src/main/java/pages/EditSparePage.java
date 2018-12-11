package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(xpath=".//*[@value='1']")
    private WebElement value;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput (String spareName){
        return spareNameInput.getAttribute("value").equals(spareName);
    }

    public void clickButtonDelete (){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD(spareTypeDD, spareType);
    }

//    public void dropDownSelect() {
//        WebElement mySelectElement = webDriver.findElement(By.id("spares_spareName"));
//        Select select = new Select(mySelectElement);
//        select.selectByValue("1");
//    }

    public void dropDownSelect(){
        actionsWithOurElements.clickOnElement(spareTypeDD);
        actionsWithOurElements.clickOnElement(value);
    }

}
