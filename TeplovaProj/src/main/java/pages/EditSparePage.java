package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 123 on 22.11.2018.
 */
public class EditSparePage extends ParentPage {

    @FindBy (id ="spares_spareName")
    private WebElement spareNameInput;

    @FindBy (id ="spares_spareType")
    private WebElement spareTypeDD;

    @FindBy (name = "delete")
    private WebElement spareDelete;

    @FindBy (name = "add")
    private WebElement buttonAdd;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spare/edit");
    }

    public boolean ckeckSpareNameInInput(String spareName){
        return spareNameInput.getAttribute("value").equals(spareName);
    }

    public void clickDeleteButton(){
        actionWithOurElements.clickOnElement(spareDelete);
    }

    public void enterSpareNameInToInput(String spareName) {
        actionWithOurElements.enterTextIntoElement(spareNameInput, spareName);
    }

    public void selectSpareTypeInDD(String spareType ) {
        actionWithOurElements.selectTextInDD(spareTypeDD,spareType);

    }


    public void clickButtonCreate( ) {
        actionWithOurElements.clickOnElement(buttonAdd);
    }
}
