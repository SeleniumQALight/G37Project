package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesEditPage extends ParentPage{

    @FindBy (id = "spares_spareName")
    WebElement inputSpareName;
    @FindBy (id = "spares_spareType")
    WebElement SpareTypeDD;
    @FindBy (name = "delete")
    WebElement buttonDelete;
    @FindBy (name = "save")
    WebElement buttonSave;
    @FindBy (id = "spares_spareType")
    WebElement spareTypeDD;
    @FindBy (name = "add")
    WebElement buttonCreate;

    public SparesEditPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void inputSpareName(String spareName) {
        actionsWithOurElements.enterTextInToElement(inputSpareName, spareName);
    }

    public void clickCreateButton() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public boolean checkSpareNameInInput(String spareName){
        return inputSpareName.getText().equals(spareName);
    }

    public void clickDeleteButton (){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void selectSpareType(String spareType) {
        actionsWithOurElements.selectTextInDD(spareTypeDD, spareType);
    }

    public WebElement getSpareType (String spareType){
        return webDriver.findElement(By.xpath(".//*[contains(text(), '" + spareType + "')]"));
    }

    public void clickOnSpareType (String spareType){
        actionsWithOurElements.clickOnElement(spareTypeDD);
        actionsWithOurElements.clickOnElement(getSpareType(spareType));
    }
}
